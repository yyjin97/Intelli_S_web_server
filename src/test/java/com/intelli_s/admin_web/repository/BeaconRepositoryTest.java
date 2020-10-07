package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.BeaconVO;
import com.intelli_s.admin_web.domain.RoomVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class BeaconRepositoryTest {

    @Autowired
    private BeaconRepository repository;

    @Test
    public void testSave() {
        BeaconVO beaconVO = new BeaconVO();

        beaconVO.setBeaconId(0);
        beaconVO.setMajor(1);
        beaconVO.setMinor(22);

        repository.save(beaconVO);
    }

    @Test
    public void testGet() {
        RoomVO room = repository.getRoomByMinor(1, 22);
        log.info(room);
    }
}