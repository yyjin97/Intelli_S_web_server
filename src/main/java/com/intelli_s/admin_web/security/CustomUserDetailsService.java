package com.intelli_s.admin_web.security;

import com.intelli_s.admin_web.domain.UserVO;
import com.intelli_s.admin_web.repository.UsersRepository;
import com.intelli_s.admin_web.security.domain.CustomUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.warn("Load User By UserName: " + userName);

        UserVO userVO = repository.getByUserId(userName);
        return userVO == null ? null : new CustomUser(userVO);
    }
}
