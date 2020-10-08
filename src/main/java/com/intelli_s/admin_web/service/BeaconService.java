package com.intelli_s.admin_web.service;

import com.intelli_s.admin_web.domain.BeaconVO;
import com.intelli_s.admin_web.domain.RoomVO;

public interface BeaconService {

    RoomVO getRoom(int major, int minor);

    void register(BeaconVO beaconVO);
}
