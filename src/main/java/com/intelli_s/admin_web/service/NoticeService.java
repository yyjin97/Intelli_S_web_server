package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.NoticeVO;

import java.util.List;

public interface NoticeService {

    NoticeVO get(int id);

    List<NoticeVO> getList();

    boolean modify(NoticeVO noticeVO);

    boolean register(NoticeVO noticeVO);
}
