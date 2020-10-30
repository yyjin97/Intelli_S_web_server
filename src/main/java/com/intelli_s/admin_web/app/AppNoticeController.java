package com.intelli_s.admin_web.app;

import com.intelli_s.admin_web.domain.Criteria;
import com.intelli_s.admin_web.domain.NoticeVO;
import com.intelli_s.admin_web.service.NoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/notice")
@Log4j2
public class AppNoticeController {

    private final NoticeService service;

    public AppNoticeController(NoticeService service) {
        this.service = service;
    }

    @GetMapping(value = "/list/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<NoticeVO>> getList(@PathVariable("bno") int bno, @RequestParam("page") int page) {
        if(bno <= 0) {
            log.warn("Invalid notice bno !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("Application get List #" + bno);

        Criteria cri = new Criteria(page, 10);
        return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<NoticeVO> get(@PathVariable("id") int id) {
        if(id <= 0) {
            log.warn("Invalid notice id !");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("Application get notice #" + id);
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }
}
