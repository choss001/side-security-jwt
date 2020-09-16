package com.security.jss.auth.jwt;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import org.apache.catalina.authenticator.AuthenticatorBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.security.jss.auth.UserDetailsImpl;
import com.security.jss.util.AuthBaseUtil;
import com.security.jss.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) {
      System.out.println("JwtAuthenticationProvider");
        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException("Bad token");
        }

        String token = authentication.getCredentials().toString();

        if (AuthBaseUtil.verify(token)) {
//UserDetails userDetails = userDetailsService.loadUserByUsername(token);
//            UserDetails userDetails = new UserDetailsImpl(id, authorities);
            return new JwtAuthenticationToken(AuthBaseUtil.getId(token), AuthBaseUtil.getPassword(token), AuthorityUtils.createAuthorityList("ADMIN"));
        } else {
            throw new BadCredentialsException("Bad token");
        }
        
        
//        String token = authentication.getCredentials().toString();

//        if (Boolean.TRUE.equals(JwtUtil.verify(token))) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(token);
//            return new JwtAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
//        } else {
//            throw new BadCredentialsException("Bad token");
//        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}