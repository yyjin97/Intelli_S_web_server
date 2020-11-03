package com.intelli_s.admin_web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AppReserveDTO {

    public AppReserveDTO(String title, String userId, String day, Integer start, Integer end, Integer bno, Integer rno) {
        this.title = title;
        this.userId = userId;
        this.day = day;
        this.start = start;
        this.end = end;
        this.bno = bno;
        this.rno = rno;
    }

    private String title;
    private String userId;

    private String day;
    private Integer start;
    private Integer end;

    private Integer bno;
    private Integer rno;
}
