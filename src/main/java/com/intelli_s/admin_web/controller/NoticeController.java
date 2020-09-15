package com.intelli_s.admin_web.controller;

import com.intelli_s.admin_web.domain.Criteria;
import com.intelli_s.admin_web.domain.PageDTO;
import com.intelli_s.admin_web.service.NoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
@Log4j2
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/list/{bno}")
    public String list(@PathVariable("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) {
        log.info("get notice list of building #" + bno);
        model.addAttribute("bno", bno);
        model.addAttribute("list", noticeService.getList(cri, bno));
        model.addAttribute("pageInfo", new PageDTO(cri, noticeService.getCntByBno(bno)));
        return "/notice/list";
    }

}
