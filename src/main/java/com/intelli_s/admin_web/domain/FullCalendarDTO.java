package com.intelli_s.admin_web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FullCalendarDTO {

    private String title;

    private String start;
    private String end;

    private String allDay;

    public FullCalendarDTO(String title, String start, String end, String allDay) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.allDay = allDay;
    }

    @Override
    public String toString() {
        return "FullCalendarDTO{" +
                "title='" + title + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", allDay=" + allDay +
                '}';
    }
}
