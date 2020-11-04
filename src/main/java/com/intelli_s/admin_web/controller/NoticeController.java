package com.intelli_s.admin_web.controller;

import com.intelli_s.admin_web.domain.Criteria;
import com.intelli_s.admin_web.domain.NoticeVO;
import com.intelli_s.admin_web.domain.PageDTO;
import com.intelli_s.admin_web.service.NoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/notice")
@Log4j2
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/list/{bno}")
    public String list(@PathVariable("bno") int bno, @ModelAttribute("cri") Criteria cri, @ModelAttribute("msg") String msg, Model model) {
        log.info("get notice list of building #" + bno);

        model.addAttribute("bno", bno);
        model.addAttribute("list", noticeService.getList(cri, bno));
        model.addAttribute("pageInfo", new PageDTO(cri, noticeService.getCntByBno(bno)));

        return "/notice/list";
    }

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") int id, @ModelAttribute("cri") Criteria cri, Model model) {

        if(id <= 0) {
            log.info("Invalid notice id!");
            return null;
        }

        log.info("get notice #" + id);
        model.addAttribute("notice", noticeService.get(id));
        return "/notice/get";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/register/{bno}")
    public String getRegister(@PathVariable("bno") int bno, Model model) {
        log.info("get register page #" + bno);

        model.addAttribute("bno", bno);
        return "/notice/register";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/register")
    public String postRegister(NoticeVO notice, RedirectAttributes rttr) {
        noticeService.register(notice);

        rttr.addAttribute("msg", "공지사항 등록 완료!");
        return "redirect:/notice/list/" + notice.getBno();
    }
}
