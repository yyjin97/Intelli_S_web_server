package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.Criteria;
import com.intelli_s.admin_web.domain.NoticeVO;

import java.util.List;

public interface NoticeService {

    NoticeVO get(int id);

    List<NoticeVO> getAllList(int bno);

    List<NoticeVO> getList(Criteria cri, int bno);

    int getCntByBno(int bno);

    boolean modify(NoticeVO noticeVO);

    void register(NoticeVO noticeVO);
}
