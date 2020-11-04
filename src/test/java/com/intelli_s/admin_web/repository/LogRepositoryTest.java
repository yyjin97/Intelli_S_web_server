package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.LogVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LogRepositoryTest {

    @Autowired
    LogRepository repository;

    @Test
    public void testSave() {
        LogVO logVO = new LogVO();
        logVO.setLno(0);
        logVO.setTitle("Intelli_S");
        logVO.setContent("알림입니다");
        logVO.setWriter("writer");
        logVO.setRegTime(new Date());

        repository.save(logVO);
    }
}