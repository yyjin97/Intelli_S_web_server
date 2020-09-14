package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.NoticeVO;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface NoticeRepository extends Repository<NoticeVO, Integer> {

    List<NoticeVO> getAllById(int id);

    List getById(int id);

    void save(NoticeVO noticeVO);
}
