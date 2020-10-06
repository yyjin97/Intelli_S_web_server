package com.intelli_s.admin_web.controller;

import com.intelli_s.admin_web.handler.MyWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private MyWebSocketHandler handler;

    @GetMapping("/")
    public String startPage() {
        return "index";
    }

    @GetMapping("/socket")
    public String socket() {
        handler.send(1, 2);
        return "socket"; }
}
