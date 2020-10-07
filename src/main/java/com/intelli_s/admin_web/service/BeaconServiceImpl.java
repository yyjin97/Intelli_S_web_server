package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.BeaconVO;
import com.intelli_s.admin_web.domain.RoomVO;
import com.intelli_s.admin_web.repository.BeaconRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BeaconServiceImpl implements BeaconService{

    private final BeaconRepository repository;

    public BeaconServiceImpl(BeaconRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomVO getRoom(int major, int minor) {
        if(major <= 0 || minor <= 0) {
            log.info("Invalid major/minor number!");
            return null;
        }

        log.info("Get room by " + major + ", " + minor);
        return repository.getRoomByMinor(major, minor);
    }

    @Override
    public void register(BeaconVO beaconVO) {
        repository.save(beaconVO);
        log.info("register beacon");
    }
}
