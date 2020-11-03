package com.intelli_s.admin_web.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        log.warn("Login Success");

        List<String> roleNames = new ArrayList<>();

        authentication.getAuthorities().forEach(auth -> {
            roleNames.add(auth.getAuthority());
        });

        log.warn("ROLE NAMES: " + roleNames);

        httpServletResponse.sendRedirect("/");
        return;
    }
}
