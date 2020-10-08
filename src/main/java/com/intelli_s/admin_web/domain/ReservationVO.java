package com.intelli_s.admin_web.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "reservation")
public class ReservationVO {

    @Id
    @Column(name = "reserve_id")
    private Integer reserveId;

    private String title;

    @Column(name = "user_id")
    private String userId;

    private String day;
    private String start;
    private String end;

    @Column(name = "allday")
    private Boolean allDay = false;

    private Integer bno;
    private Integer rno;

    @Column(name = "reg_time")
    private Date regTime;

    @Override
    public String toString() {
        return "ReservationVO{" +
                "reserveId=" + reserveId +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", day='" + day + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", allDay=" + allDay +
                ", bno=" + bno +
                ", rno=" + rno +
                ", regTime=" + regTime +
                '}';
    }
}
