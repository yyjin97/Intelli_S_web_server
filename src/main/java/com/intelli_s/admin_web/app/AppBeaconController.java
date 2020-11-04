package com.intelli_s.admin_web.app;

import com.intelli_s.admin_web.domain.BeaconVO;
import com.intelli_s.admin_web.domain.RoomVO;
import com.intelli_s.admin_web.handler.MyWebSocketHandler;
import com.intelli_s.admin_web.service.BeaconService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/beacon")
@Log4j2
public class AppBeaconController {

    private final BeaconService service;
    private final MyWebSocketHandler handler;

    public AppBeaconController(BeaconService service, MyWebSocketHandler handler) {
        this.service = service;
        this.handler = handler;
    }

    @PostMapping(value = "/open/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoomVO> openRoom(@RequestBody BeaconVO beacon, @PathVariable("bno") int bno) {

        if(beacon == null) {
            log.info("beacon data is NULL!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        int major = beacon.getMajor();
        int minor = beacon.getMinor();

        minor += bno;

        RoomVO room = service.getRoom(major, minor);
        if(room == null) {
            log.warn("존재하지 않는 major/minor 번호입니다");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(!handler.send(room.getBno(), room.getRno())) {
            log.warn("Room #" + room.getRoomId() + " open fail!");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("Room #" + room.getRoomId() + " open!");
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
}
