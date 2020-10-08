package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.ReservationVO;

import java.util.List;

public interface ReservationService {

    List<ReservationVO> getListByDay(String start, String end);

    void register(ReservationVO reservation);
}
