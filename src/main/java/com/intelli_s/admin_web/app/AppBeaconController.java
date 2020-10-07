package com.intelli_s.admin_web.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/beacon")
public class AppBeaconController {

    @PostMapping("/open")
    public void openDoor(@RequestBody String minor) {

    }
}
