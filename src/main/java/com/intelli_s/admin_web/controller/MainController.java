package com.intelli_s.admin_web.controller;

import com.intelli_s.admin_web.handler.MyWebSocketHandler;
import com.intelli_s.admin_web.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @GetMapping("/reserve/{bno}/{rno}")
    public String reserve(@PathVariable("bno") Integer bno, @PathVariable("rno") Integer rno, Model model) {

        String rName[] = {"424호", "522호", "525호", "소프트웨어 실습실", "하드웨어 실습실", "541호", "101호", "102호", "401호"};
        String bName = reservationService.getBuildingNameByBno(bno);

        model.addAttribute("bno", bno);
        model.addAttribute("bname", bName);
        model.addAttribute("rno", rno);
        model.addAttribute("rname", rName[bno * 3 + rno]);

        return "reserve/calendar";
    }
}
