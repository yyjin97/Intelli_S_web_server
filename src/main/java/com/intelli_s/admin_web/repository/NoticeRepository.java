package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.NoticeVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NoticeRepository extends Repository<NoticeVO, Integer> {

    @Query("SELECT notice FROM NoticeVO notice WHERE notice.bno = :bno")
    List<NoticeVO> getList(int bno);

    @Query(value = "SELECT * FROM notice WHERE notice.bno = :bno ORDER BY notice.id DESC LIMIT :start, :amount", nativeQuery = true)
    List<NoticeVO> getListByBno(int bno, int start, int amount);

    NoticeVO getById(int id);

    @Query("SELECT COUNT(notice.id) FROM NoticeVO notice WHERE notice.bno = :bno")
    int getCntByBno(int bno);

    @Query("UPDATE NoticeVO notice SET notice.title = :#{#noticeVO.title}, notice.content = :#{#noticeVO.content}," +
            "notice.updateTime = :#{#noticeVO.update_time} WHERE notice.id = :#{#noticeVO.id}")
    @Transactional
    @Modifying
    int updateNotice(NoticeVO noticeVO);

    void save(NoticeVO noticeVO);
}
