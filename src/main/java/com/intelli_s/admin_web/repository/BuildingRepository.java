package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.BuildingVO;
import org.springframework.data.repository.Repository;

public interface BuildingRepository extends Repository<BuildingVO, Integer> {

    BuildingVO getByBno(int bno);

    void save(BuildingVO buildingVO);
}
