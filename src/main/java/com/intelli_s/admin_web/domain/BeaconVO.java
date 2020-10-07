package com.intelli_s.admin_web.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "beacon")
public class BeaconVO {

    @Id
    @Column(name = "beacon_id")
    private Integer beaconId;

    private Integer major;
    private Integer minor;

    @Column(name = "room_id")
    private Integer roomId;

    @Override
    public String toString() {
        return "BeaconVO{" +
                "beaconId=" + beaconId +
                ", major=" + major +
                ", minor=" + minor +
                ", roomId=" + roomId +
                '}';
    }
}
