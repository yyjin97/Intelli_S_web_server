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
@Table(name = "notice")
public class NoticeVO {

    @Id
    private Integer id;

    private String title;

    private String content;

    private String writer;

    private Integer bno;

    @Column(name = "reg_time")
    private Date regTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Override
    public String toString() {
        return "NoticeVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", bno=" + bno +
                ", regTime=" + regTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
