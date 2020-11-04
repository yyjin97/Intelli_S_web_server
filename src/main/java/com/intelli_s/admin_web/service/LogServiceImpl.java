package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.LogVO;
import com.intelli_s.admin_web.repository.LogRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class LogServiceImpl implements LogService{

    @Autowired
    private LogRepository repository;

    @Override
    public List<LogVO> getList() {
        log.info("Get Notification List");
        return repository.getList();
    }

    @Override
    public void register(String title, String content) {
        LogVO logVO = new LogVO();
        logVO.setTitle(title);
        logVO.setContent(content);
        logVO.setWriter("TempWriter!!");   /////수정!!!!!!!!
        logVO.setRegTime(new Date());

        repository.save(logVO);
    }
}
