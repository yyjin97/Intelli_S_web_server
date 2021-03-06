package com.intelli_s.admin_web.fcm;

import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

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

        String sampleData[] = {"dWKiPqdsSmGVpfvTKm9tzj:APA91bGbSeUGId3YBaPjvVVYdPECab8-gmmGnPV7Q9ukGIi6lr2QpiasGPbsaa5F93ReTFGxVgNhvkKvnY3hRV1R5jkKC13O4e2ooNVMLBTFm3DoSxK2MNBzJKg6MpSYbtGDLvFetc0g",
                "eac_y11zQg2U9lwclS2oMC:APA91bHF81qEXZIaIKubnpX_Vc6lOXyKHhr6FcNOVrjBr8J1tCq-Gbupv6FKPLC63_bIs-3_w6_Ae6RFtzNODuXW4zu-u-IfR-txMRInTqe99VbG9RzzZDo9xGit9Cjk9Ol6TD1AGrcw"};

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
