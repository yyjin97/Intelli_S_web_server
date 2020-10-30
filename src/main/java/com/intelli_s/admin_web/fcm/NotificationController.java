package com.intelli_s.admin_web.fcm;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class NotificationController {

    @Autowired
    PushNotificationService service;

    @GetMapping("/send")
    public ResponseEntity<String> send() throws JSONException, InterruptedException {
        String notifications = PushNotifications.NotificationJson();

        HttpEntity<String> request = new HttpEntity<>(notifications);

        CompletableFuture<String> pushNotification = service.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try{
            String response = pushNotification.get();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }
}
