package com.security.jss.auth.ajax.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.jss.domain.Member;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class AjaxAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper objectMapper;

    public AjaxAuthenticationFilter(RequestMatcher requestMatcher, ObjectMapper objectMapper) {
        super(requestMatcher);
        this.objectMapper = objectMapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
      System.out.println("AjaxAuthenticationFilter");
        if (isJson(request)) {
        	System.out.println(request.getReader());
            Member member = objectMapper.readValue(request.getReader(), Member.class);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member.getId(), member.getPassword());
            return getAuthenticationManager().authenticate(authentication);
        } else {
            throw new AccessDeniedException("Don't use content type for " + request.getContentType());
        }
    }

    private boolean isJson(HttpServletRequest request) {
        return MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(request.getContentType());
    }
}