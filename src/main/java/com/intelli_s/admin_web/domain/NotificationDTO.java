package com.intelli_s.admin_web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NotificationDTO {

    private String title;
    private String content;

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
