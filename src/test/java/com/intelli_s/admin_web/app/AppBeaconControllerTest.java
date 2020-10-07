package com.intelli_s.admin_web.app;

import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Log4j2
class AppBeaconControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testOpen() throws Exception{
        int major = 1;
        int minor = 22;

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("major", major);
        jsonObject.put("minor", minor);

        mockMvc.perform(post("/app/beacon/open")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonObject.toString()))
                .andExpect(status().isOk())
                .andDo(print());
    }
}