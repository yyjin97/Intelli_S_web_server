package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.ReservationVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends Repository<ReservationVO, Integer> {

    @Query("SELECT reserve FROM ReservationVO reserve WHERE reserve.day >= :day_s and reserve.day < :day_e")
    List<ReservationVO> getListByDay(String day_s, String day_e);

    void save(ReservationVO reservation);
}
