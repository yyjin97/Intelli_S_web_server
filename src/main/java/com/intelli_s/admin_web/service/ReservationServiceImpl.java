package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.ReservationVO;
import com.intelli_s.admin_web.repository.ReservationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository repository;

    public ReservationServiceImpl(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ReservationVO> getListByDay(String start, String end) {
        log.info("Get reservation " + start + "~" + end);
        return repository.getListByDay(start, end);
    }

    @Override
    public void register(ReservationVO reservation) {
        reservation.setRegTime(new Date());

        log.info("bno:" + reservation.getBno() + " rno:" + reservation.getRno() + " " + reservation.getDay() + " " + reservation.getStart() + "~" + reservation.getEnd() + " 예약등록");
        repository.save(reservation);
    }
}
