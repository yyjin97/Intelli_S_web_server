package com.intelli_s.admin_web.app;

import com.intelli_s.admin_web.fcm.PushNotifications;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class RpiController {

    @Autowired
    private PushNotifications pushNotifications;

    int cnt = 0;

    @GetMapping("/fire")
    public void fire() {
        if(cnt > 0)
            return;

        cnt += 1;
        log.info("화재발생 !");

        if(pushNotifications.send("Emergency!", "A fire broke out in the library")) {
            log.info("화재 알림 Notification 전송");
        }
        else {
            log.info("화재 알림 Notification 전송 오류!");
        }
    }
}
