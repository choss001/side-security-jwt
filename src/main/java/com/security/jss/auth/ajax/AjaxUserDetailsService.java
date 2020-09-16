package com.security.jss.auth.ajax;

import com.security.jss.auth.UserDetailsImpl;
import com.security.jss.domain.Member;
import com.security.jss.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AjaxUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberService memberService;

	@Override
	public UserDetails loadUserByUsername(String username) {
	  System.out.println("AjaxUserDetailService");
//		Member user = repository.findById(username).orElse(null);
		Member member = new Member();
		member.setId(username);
		memberService.getMemberUser(member);

		if (memberService.getMemberUser(member) == null) {
			throw new UsernameNotFoundException(username + "아이디가 없습니다.");
		}

		return new UserDetailsImpl(memberService.getMemberUser(member), AuthorityUtils.createAuthorityList(memberService.getMemberUser(member).getRole()));
	}
}