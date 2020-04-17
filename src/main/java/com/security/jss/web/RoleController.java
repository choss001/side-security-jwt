package com.security.jss.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.jss.auth.UserDetailsImpl;
import com.security.jss.auth.jwt.JwtInfo;
import com.security.jss.domain.Member;
import com.security.jss.util.JwtUtil;

@RestController
public class RoleController {

	@PostAuthorize("hasAuthority('USER')")
	@GetMapping("/user")
	public String user(Authentication authentication) {
		System.out.println("RoleController : " + authentication.getAuthorities().toString());
		System.out.println("RoleController : " + authentication.getPrincipal());
		return "I'm Jwt Token User!";
	}

	@GetMapping("/test")
	public String test(Authentication authentication, HttpServletResponse response) {
		UserDetails userDetails = new UserDetailsImpl(authentication.getPrincipal().toString(), new ArrayList<>(authentication.getAuthorities()));
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setHeader(JwtInfo.HEADER_NAME, JwtUtil.createToken(userDetails));
//		System.out.println("RoleController : " + authentication.getAuthorities().toString());
//		System.out.println("RoleController : " + authentication.getPrincipal());
		return "I'm Jwt Token User!";

	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/admin")
	public String admin(Authentication authentication) {
		System.out.println("RoleController : " + authentication.getAuthorities().toString());
		System.out.println("RoleController : " + authentication.getPrincipal());
		return "I'm Jwt Token Admin!";
	}
}
