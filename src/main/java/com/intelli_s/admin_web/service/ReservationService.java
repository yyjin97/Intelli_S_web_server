package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.ReservationVO;

import java.util.List;

public interface ReservationService {

    List<ReservationVO> getListByDay(String start, String end);

    Boolean checkReservation(String day, String start, String end);

    int getCntById(Integer id);

    void remove(Integer id);

    void register(ReservationVO reservation);
}
