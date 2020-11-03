package com.intelli_s.admin_web.controller;

import com.intelli_s.admin_web.handler.MyWebSocketHandler;
import com.intelli_s.admin_web.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private final MyWebSocketHandler handler;
    private final ReservationService reservationService;

    public MainController(MyWebSocketHandler handler, ReservationService reservationService) {
        this.handler = handler;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String startPage() {
        return "index";
    }

    @GetMapping("/socket")
    public String socket() {
        handler.send(1, 2);
        return "socket";
    }

    @GetMapping("/reserve/{bno}")
    public String reserve(@PathVariable("bno") Integer bno, Model model) {

        String bName = reservationService.getBuildingNameByBno(bno);

        model.addAttribute("bno", bno);
        model.addAttribute("bname", bName);

        return "reserve/calendar";
    }
}
