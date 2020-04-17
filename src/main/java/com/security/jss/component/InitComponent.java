//package com.security.jss.component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.security.jss.domain.Member;
//import com.security.jss.repository.MemberRepository;
//
//@Component
//public class InitComponent implements ApplicationRunner {
//
//	@Autowired
//	private MemberRepository repository;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Transactional
//	@Override
//	public void run(ApplicationArguments args) {
//		Member user = new Member("wonchul", passwordEncoder.encode("1234"),"USER");
//		repository.save(user);
//
//		Member admin = new Member("naeun", passwordEncoder.encode("1234"), "ADMIN");
//		repository.save(admin);
//	}
//}