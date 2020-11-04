package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.LogVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LogService {

    List<LogVO> getList();

    void register(String title, String content);
}
