package com.intelli_s.admin_web.app;

import com.intelli_s.admin_web.domain.LogVO;
import com.intelli_s.admin_web.service.LogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
@Log4j2
public class AppLogController {

    @Autowired
    private LogService service;

    @GetMapping("/list")
    public ResponseEntity<List<LogVO>> getList() {

        log.info("Get Notification Log");
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }
}
