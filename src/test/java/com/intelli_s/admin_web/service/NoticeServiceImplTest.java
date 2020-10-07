package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.NoticeVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.Date;

@SpringBootTest
@Log4j2
class NoticeServiceImplTest {

    @Autowired
    private NoticeService noticeService;

    @Test
    public void testGet() {
        int id = 2;
        log.info(noticeService.get(2));
    }

    @Test
    public void testRegister() {
        NoticeVO noticeVO = new NoticeVO();
        Date now = new Date();

        noticeVO.setId(0);
        noticeVO.setTitle("new title");
        noticeVO.setContent("new content");
        noticeVO.setWriter("writer1");
        noticeVO.setBno(2);
        noticeVO.setRegTime(now);
        noticeVO.setUpdateTime(now);

        noticeService.register(noticeVO);
    }

    @Test
    public void testModify() {
        NoticeVO noticeVO = noticeService.get(3);

        noticeVO.setTitle("제목");
        noticeVO.setContent("내용입니다");

        log.info(noticeService.modify(noticeVO));
    }
}