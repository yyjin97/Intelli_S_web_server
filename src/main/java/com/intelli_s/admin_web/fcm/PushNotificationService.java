package com.intelli_s.admin_web.fcm;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class PushNotificationService {
    private static final String serverKey = "AAAAIcZeYtg:APA91bFuGmaRFM7qNqwzNG8jz1c_rw0CzS4ywLawlaVel2eQ5XzA1QaxJloVV4ceYWZQldxAmHJS1rc_LhXn5o1jOqofb3-s9q4v_o2A1KO11QqyyE5i74kbJoBzeCoIFUdg2vFzqvne";
    private static final String API_URL = "https://fcm.googleapis.com/fcm/send";

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new RequestInterceptor("Authorization", "key=" + serverKey));
        interceptors.add(new RequestInterceptor("Content-Type", "application/json; charset=utf-8"));
        restTemplate.setInterceptors(interceptors);

        String response = restTemplate.postForObject(API_URL, entity, String.class);
        return CompletableFuture.completedFuture(response);
    }

}
