package com.intelli_s.admin_web.fcm;

import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PushNotifications {

    public static String NotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {"dWKiPqdsSmGVpfvTKm9tzj:APA91bHYrf-3XVIkQDiPNomBU5bhPBXPj4E4fKwZmA2CxHGJSyn6rvk9PHHiJRiGkjKHNuXxXb0U72wmwZUtjT1NM2eXxPHlkdhbJizXpqBDgnF0P8HFYUeZZgzjcNMY4yVZ9HSeRJ2G"};

        JSONObject body = new JSONObject();

        List<String> tokenList = new ArrayList<>();

        for(int i = 0; i < sampleData.length; i++)
            tokenList.add(sampleData[i]);

        JSONArray array = new JSONArray();

        for(int i = 0; i < tokenList.size(); i++)
            array.put(tokenList.get(i));

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        notification.put("title", "Intelli_S");
        notification.put("body", "tempBody");

        body.put("notification", notification);

        log.info("Push Notification: " + body.toString());
        return body.toString();
    }
}
