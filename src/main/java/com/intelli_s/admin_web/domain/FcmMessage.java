package com.intelli_s.admin_web.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FcmMessage {

    private boolean validate_only;
    private Message message;

    public FcmMessage(boolean validate_only, Message message) {
        this.validate_only = validate_only;
        this.message = message;
    }

    @Getter
    @Builder
    public static class Message {
        private Notification notification;
        private String token;
    }

    @Getter
    @Builder
    public static class Notification {
        private String title;
        private String body;

        public Notification(String title, String body) {
            this.title = title;
            this.body = body;
        }
    }
}
