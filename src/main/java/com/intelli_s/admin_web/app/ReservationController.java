package com.intelli_s.admin_web.app;

import com.intelli_s.admin_web.domain.AppReserveDTO;
import com.intelli_s.admin_web.domain.FullCalendarDTO;
import com.intelli_s.admin_web.domain.ReservationVO;
import com.intelli_s.admin_web.service.ReservationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reserve")
@Log4j2
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping(value = "/lookup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppReserveDTO>> appLookup(@RequestParam String day, @RequestParam Integer bno) {

        day = day.replace('/', '-');

        List<ReservationVO> list = service.getListByDayBno(day, bno);
        List<AppReserveDTO> appList = new ArrayList<>();

        list.forEach(e -> {
            appList.add(new AppReserveDTO(e.getTitle(), e.getUserId(), e.getDay(), Integer.parseInt(e.getStart().substring(0,2)), Integer.parseInt(e.getEnd().substring(0,2)),e.getBno(), e.getRno()));
        });

        log.info("App에 예약목록을 전송: " + day + ", bno: " + bno);
        return new ResponseEntity<>(appList, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, FullCalendarDTO>> getCalendar(@RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("bno") Integer bno, @RequestParam("rno") Integer rno) {
        if(start.length() > 10) {
            start = start.substring(0, 10);
        }
        if(end.length() > 10) {
            end = end.substring(0, 10);
        }
        start = start.replace('-', '/');
        end = end.replace('-','/');

        List<ReservationVO> list = service.getListByDay(start, end, bno, rno);
        Map<String, FullCalendarDTO> map = new HashMap<>();
        Integer cnt = 1;
        for(ReservationVO e : list){
            map.put(cnt.toString(), new FullCalendarDTO(e.getTitle()+" - " + e.getUserId(), e.getDay()+"T"+e.getStart(), e.getDay()+"T"+e.getEnd(), e.getAllDay().toString()));
            cnt++;
        }

        log.info(map);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap<String, String>> registerReservation(@RequestBody ReservationVO reserve) {

        HashMap<String, String> map = new HashMap<>();

        if(reserve.getStart().compareTo("09:00:00") < 0 || reserve.getEnd().compareTo("17:00:00") > 0) {
            log.info("예약이 불가한 요청입니다.");
            map.put("ret", "fail");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        if(service.checkReservation(reserve.getDay(), reserve.getStart(), reserve.getEnd(), reserve.getBno(), reserve.getRno())) {
            log.info("이미 예약이 존재합니다 " + reserve.getDay() + " " + reserve.getStart() + " ~ " + reserve.getEnd());
            map.put("ret", "fail");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }

        reserve.setUserId("user");
        reserve.setReserveId(0);
        service.register(reserve);
        log.info(reserve.getDay() + " " + reserve.getStart() + " ~ " + reserve.getEnd() + " 예약 완료!");
        map.put("ret", "success");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping(value = "/cancel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> cancelReservation(@RequestParam Integer id) {

        if(id == null || service.getCntById(id) == 0) {
            log.info("Id가 존재하지 않습니다.");
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }

        service.remove(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
