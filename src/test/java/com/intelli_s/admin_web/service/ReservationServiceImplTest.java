package com.intelli_s.admin_web.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ReservationServiceImplTest {

    @Autowired
    private ReservationService service;

    @Test
    public void testGet(){
        log.info(service.getListByDay("2020/10/04", "2020/10/10"));
    }
}