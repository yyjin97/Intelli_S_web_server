package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.NoticeVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Log4j2
class NoticeRepositoryTest {

    @Autowired
    NoticeRepository repository;

    @Test
    public void testGetById() {
        int id = 1;

        log.info(repository.getById(id));
    }

    @Test
    public void testUpdateNotice() {
        NoticeVO noticeVO = repository.getById(1);
        Date now = new Date();

        noticeVO.setTitle("새 제목");
        noticeVO.setContent("변경 후 내용입니다");
        noticeVO.setUpdate_time(now);

        log.info(repository.updateNotice(noticeVO));
    }

    @Test
    public void testSave() {
        NoticeVO noticeVO = new NoticeVO();
        Date date = new Date();

        noticeVO.setId(0);
        noticeVO.setTitle("title");
        noticeVO.setContent("content!");
        noticeVO.setWriter("writer");
        noticeVO.setBno(1);
        noticeVO.setReg_time(date);
        noticeVO.setUpdate_time(date);

        repository.save(noticeVO);
    }
}