package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.ReservationVO;
import com.intelli_s.admin_web.repository.ReservationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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

    //return 값이 true 이면 이미 예약이 존재, false 이면 예약이 없는 경우
    @Override
    public Boolean checkReservation(String day, String start, String end) {
        log.info("Check reservation " + day + " " + start + " ~ " + end);
        return repository.getCntByDay(day, start, end) > 0;
    }

    @Override
    public int getCntById(Integer id) {
        log.info("Get Count By #" + id);
        return repository.getCntById(id);
    }

    @Override
    public void remove(Integer id) {
        log.info("Delete Reservation #" + id);
        repository.removeByReserveId(id);
    }

    @Override
    public void register(ReservationVO reservation) {
        reservation.setRegTime(new Date());

        log.info("bno:" + reservation.getBno() + " rno:" + reservation.getRno() + " " + reservation.getDay() + " " + reservation.getStart() + "~" + reservation.getEnd() + " 예약등록");
        repository.save(reservation);
    }
}
