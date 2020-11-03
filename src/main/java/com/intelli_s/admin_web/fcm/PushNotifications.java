package com.intelli_s.admin_web.fcm;

import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@Log4j2
public class PushNotifications {

    @Autowired
    PushNotificationService service;

    public Boolean send(String title, String content) {
        String notifications = PushNotifications.NotificationJson(title, content);

        HttpEntity<String> request = new HttpEntity<>(notifications);

        CompletableFuture<String> pushNotification = service.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try{
            String response = pushNotification.get();
            log.info(response);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String NotificationJson(String title, String content) throws JSONException {

        String sampleData[] = {"dWKiPqdsSmGVpfvTKm9tzj:APA91bExCRlVjl2pJHPHKusRquet0nvvRdceO0gRrGS0zzyt7nKm0DcEdJtMUSOZbKaP-7t8yx6ZCWUJQ19W4dT5DxOrkB0o4vEMH3ZqTb3fLu8rGNQO-OPPyYhC6o0OAsAVmG3GBE3q"};

        JSONObject body = new JSONObject();

        List<String> tokenList = new ArrayList<>();

        for(int i = 0; i < sampleData.length; i++)
            tokenList.add(sampleData[i]);

        JSONArray array = new JSONArray();

        for(int i = 0; i < tokenList.size(); i++)
            array.put(tokenList.get(i));

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        notification.put("title", title);
        notification.put("body", content);

        body.put("notification", notification);

        log.info("Push Notification: " + body.toString());
        return body.toString();
    }
}
