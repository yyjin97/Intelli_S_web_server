package com.intelli_s.admin_web.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Log4j2
public class MyWebSocketHandler extends TextWebSocketHandler {

    //key = bno, value = session
    private Map<Integer, WebSocketSession> map = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Web socket 연결: " + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        map.values().removeAll(Collections.singleton(session));
        log.info("Web socket 연결 종료: " + session.getId());
    }

    //Client to Server
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String data = message.getPayload();
        log.info(data);
        Map<String, Object> m = new ObjectMapper().readValue(data, new TypeReference<>(){});
        List<Integer> bnoList = new ObjectMapper().readValue(m.get("bno").toString(), new TypeReference<>() {});
        for(Integer bno : bnoList) {
            map.put(bno, session);
            log.info("Web socket 저장: " + bno + ", " +session.getId());
        }
    }

    //Server to Client
    public void send(Integer bno, Integer rno) {
        WebSocketSession session = map.get(bno);
        try{
            log.info("Web socket 전송: bno=" + bno + " rno=" + rno);
            session.sendMessage(new TextMessage(bno+","+rno));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
