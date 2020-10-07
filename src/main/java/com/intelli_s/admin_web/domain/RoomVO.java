package com.intelli_s.admin_web.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "room")
public class RoomVO {

    @Id
    @Column(name = "room_id")
    private Integer roomId;

    private String name;

    private Integer bno;
    private Integer rno;

    @Override
    public String toString() {
        return "RoomVO{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", bno=" + bno +
                ", rno=" + rno +
                '}';
    }
}
