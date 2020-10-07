package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.BeaconVO;
import com.intelli_s.admin_web.domain.RoomVO;
import javassist.compiler.ast.Pair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BeaconRepository extends Repository<BeaconVO, Integer> {

    @Query("SELECT room FROM BeaconVO beacon join RoomVO room on beacon.roomId = room.roomId " +
            "WHERE beacon.major = :major and beacon.minor = :minor")
    RoomVO getRoomByMinor(int major, int minor);

    void save(BeaconVO beacon);
}
