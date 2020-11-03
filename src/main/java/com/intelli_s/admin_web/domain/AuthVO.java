package com.intelli_s.admin_web.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "auth")
public class AuthVO {

    @Id
    private int ano;

    @Column(name = "userid")
    private String userId;

    private String auth;

    @Override
    public String toString() {
        return "AuthVO{" +
                "ano=" + ano +
                ", userId='" + userId + '\'' +
                ", auth='" + auth + '\'' +
                '}';
    }
}
