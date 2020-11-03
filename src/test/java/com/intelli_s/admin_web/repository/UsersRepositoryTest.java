package com.intelli_s.admin_web.repository;

import com.intelli_s.admin_web.domain.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Table;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersRepositoryTest {

    @Autowired
    private UsersRepository repository;

    @Test
    public void testSave() {
        UserVO userVO = new UserVO();

        userVO.setUserId("yyjin97@naver.com");
        userVO.setUserName("yyjin");
        userVO.setPhoneNum("01012341234");

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userVO.setUserPw(encoder.encode("12345"));

        repository.save(userVO);
    }
}