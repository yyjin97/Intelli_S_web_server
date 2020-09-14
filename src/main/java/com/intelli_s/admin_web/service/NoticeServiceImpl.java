package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.NoticeVO;
import com.intelli_s.admin_web.repository.NoticeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository repository;

    public NoticeServiceImpl(NoticeRepository repository) {
        this.repository = repository;
    }

    @Override
    public NoticeVO get(int id) {
        if(id <= 0) {
            log.info("Invalid Notice Id!");
            return null;
        }

        log.info("get notice #" + id);
        return repository.getById(id);
    }

    @Override
    public List<NoticeVO> getList() {
        log.info("get notice list !");
        return repository.getList();
    }

    @Override
    public boolean modify(NoticeVO noticeVO) {
        if(noticeVO.getId() <= 0) {
            log.info("Invalid Notice Id !");
            return false;
        }

        Date now = new Date();

        noticeVO.setUpdate_time(now);
        log.info("modify notice #" + noticeVO.getId());
        return repository.updateNotice(noticeVO) == 1;
    }

    @Override
    public boolean register(NoticeVO noticeVO) {
        Date now = new Date();

        noticeVO.setReg_time(now);
        noticeVO.setUpdate_time(now);

        log.info("register notice !");
        repository.save(noticeVO);
        return true;
    }
}
