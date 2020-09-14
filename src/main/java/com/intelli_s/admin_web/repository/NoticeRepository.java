package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.NoticeVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoticeRepository extends Repository<NoticeVO, Integer> {

    @Query("SELECT notice FROM NoticeVO notice WHERE notice.id > 0")
    List<NoticeVO> getList();

    NoticeVO getById(int id);

    @Query("UPDATE NoticeVO notice SET notice.title = :#{#noticeVO.title}, notice.content = :#{#noticeVO.content}," +
            "notice.update_time = :#{#noticeVO.update_time} WHERE notice.id = :#{#noticeVO.id}")
    @Transactional
    @Modifying
    int updateNotice(NoticeVO noticeVO);

    void save(NoticeVO noticeVO);
}
