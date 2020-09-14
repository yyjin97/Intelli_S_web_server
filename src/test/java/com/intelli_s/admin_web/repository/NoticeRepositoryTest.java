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
    public void testGetAllById() {
        int id = 1;

        repository.getAllById(id).forEach(System.out::println);
    }

    @Test
    public void testGetById() {
        int id = 1;

        log.info(repository.getById(id));
    }

    @Test
    public void testSave() {
        NoticeVO noticeVO = new NoticeVO();
        Date date = new Date();

        noticeVO.setId(1);
        noticeVO.setTitle("title");
        noticeVO.setContent("content!");
        noticeVO.setWriter("writer");
        noticeVO.setBuilding_id(1);
        noticeVO.setReg_time(date);
        noticeVO.setUpdate_time(date);

        repository.save(noticeVO);
    }
}