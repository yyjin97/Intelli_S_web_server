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
@Table(name = "log")
public class LogVO {

    @Id
    Integer lno = 0;

    String title;
    String content;
    String writer;

    @Column(name = "reg_time")
    Date regTime;

    @Override
    public String toString() {
        return "LogVO{" +
                "lno=" + lno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regTime=" + regTime +
                '}';
    }
}
