package com.security.jss.service.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.jss.domain.Member;
import com.security.jss.mapper.MemberMapper;
import com.security.jss.service.MemberService;



@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;



    private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);
    
    @Override
    public Member getMemberUser(Member member) {
    	return memberMapper.getMemberUser(member);
    }

}
