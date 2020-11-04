package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.LogVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LogRepository extends Repository<LogVO, Integer> {

    @Query("SELECT log FROM LogVO log")
    List<LogVO> getList();

    void save(LogVO logVO);
}
