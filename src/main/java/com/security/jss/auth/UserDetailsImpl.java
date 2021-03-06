package com.security.jss.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.security.jss.domain.Member;

import java.util.List;

public class UserDetailsImpl extends User {

	public UserDetailsImpl(String id, List<GrantedAuthority> authorities) {
		super(id, "", authorities);
	}

	public UserDetailsImpl(Member member, List<GrantedAuthority> authorities) {
		super(member.getId(), member.getPassword(), authorities);
	}
}