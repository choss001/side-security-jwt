package com.security.jss.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import com.security.jss.auth.jwt.JwtInfo;
import com.security.jss.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Component
@Slf4j
public class BaseSecurityHandler
    implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) {
    System.out.println("BaseSecurityHandler");
    UserDetails userDetails = new UserDetailsImpl(authentication.getPrincipal().toString(),
        new ArrayList<>(authentication.getAuthorities()));
    log.info(authentication.getPrincipal().toString());
    
    Cookie myCookie = new Cookie("token", JwtUtil.createToken(userDetails));
    myCookie.setMaxAge(60 * 60 * 24);
    response.addCookie(myCookie);
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setHeader(JwtInfo.HEADER_NAME, JwtUtil.createToken(userDetails));
  }

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) {
    throw new ResponseStatusException(HttpStatus.FORBIDDEN, exception.getMessage());
  }
}
