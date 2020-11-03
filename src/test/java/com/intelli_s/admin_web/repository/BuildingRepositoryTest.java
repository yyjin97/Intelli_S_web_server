package com.intelli_s.admin_web.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class BuildingRepositoryTest {

    @Autowired
    private BuildingRepository repository;

    @Test
    public void testGet() {
        log.info(repository.getByBno(1).getName());
    }
}