package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.ReservationVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Log4j2
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository repository;

    @Test
    public void testGetListByDay() {
        String day_s = "2020/10/04";
        String day_e = "2020/10/11";

        log.info(repository.getListByDay(day_s, day_e, 1, 0));
    }

    @Test
    public void testSave() {
        ReservationVO reservation = new ReservationVO();

        reservation.setReserveId(0);
        reservation.setTitle("회의");
        reservation.setUserId("yyjin");
        reservation.setDay("2020/10/01");
        reservation.setStart("07:30:00");
        reservation.setEnd("14:00:00");
        reservation.setBno(1);
        reservation.setRno(2);
        reservation.setRegTime(new Date());

        repository.save(reservation);
    }

    @Test
    public void testGetCnt() {
        log.info(repository.getCntByDay("2020/10/10", "07:30:00","08:30:00", 0, 0));
    }

    @Test
    public void testRemove() {
        repository.removeByReserveId(8);
    }
}