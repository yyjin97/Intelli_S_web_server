package com.intelli_s.admin_web.controller;

import com.intelli_s.admin_web.domain.LogVO;
import com.intelli_s.admin_web.domain.NotificationDTO;
import com.intelli_s.admin_web.fcm.PushNotifications;
import com.intelli_s.admin_web.repository.LogRepository;
import com.intelli_s.admin_web.service.LogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/notification")
@Log4j2
public class NotificationController {

    @Autowired
    private PushNotifications pushNotifications;

    @Autowired
    private LogService service;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/send")
    public String getSend() {
        return "/notification/send";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/send")
    public String postSend(NotificationDTO notificationDTO, Model model) {

        if(pushNotifications.send(notificationDTO.getTitle(), notificationDTO.getContent())) {
            log.info("Notification 전송: " + notificationDTO.getTitle() + ", " + notificationDTO.getContent());
            service.register(notificationDTO.getTitle(), notificationDTO.getContent());
            model.addAttribute("msg", "알림 전송 완료!");
        }
        else {
            log.info("Notification 전송 오류!");
        }

        return "notification/send";
    }

}
