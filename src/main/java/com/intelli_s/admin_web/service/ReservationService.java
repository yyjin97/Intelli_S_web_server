package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.ReservationVO;

import java.util.List;

public interface ReservationService {

    String getBuildingNameByBno(Integer bno);

    List<ReservationVO> getListByDay(String start, String end, int bno, int rno);

    List<ReservationVO> getListByDayBno(String day, Integer bno);

    Boolean checkReservation(String day, String start, String end, int bno, int rno);

    int getCntById(Integer id);

    void remove(Integer id);

    void register(ReservationVO reservation);
}
