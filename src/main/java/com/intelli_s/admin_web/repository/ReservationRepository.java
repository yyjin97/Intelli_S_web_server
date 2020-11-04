package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.AppReserveDTO;
import com.intelli_s.admin_web.domain.ReservationVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends Repository<ReservationVO, Integer> {

    @Query("SELECT reserve FROM ReservationVO reserve WHERE reserve.day >= :day_s and reserve.day < :day_e and reserve.bno = :bno and reserve.rno = :rno")
    List<ReservationVO> getListByDay(String day_s, String day_e, int bno, int rno);

    @Query("SELECT reserve FROM ReservationVO reserve WHERE reserve.day = :day and reserve.bno = :bno")
    List<ReservationVO> getListByDayBno(String day, Integer bno);

    @Query("SELECT COUNT(reserve) FROM ReservationVO reserve WHERE reserve.day = :day and reserve.bno = :bno and reserve.rno = :rno " +
            "and ((reserve.start <= :start and reserve.end > :start) or (reserve.start > :end and reserve.end >= :end))")
    int getCntByDay(String day, String start, String end, int bno, int rno);

    @Query("SELECT COUNT(reserve) FROM ReservationVO reserve WHERE reserve.reserveId = :id")
    int getCntById(Integer id);

    @Transactional
    void removeByReserveId(Integer id);

    void save(ReservationVO reservation);
}
