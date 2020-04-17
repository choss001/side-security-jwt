package com.security.jss.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		System.out.println("여기 들어오는거 맞지?");
		mav.setViewName("jss/login");
		return mav;
	}
	
	@RequestMapping("/auth")
	public ModelAndView auth() {
		System.out.println("여기 들어오는거 맞지?");
		return null;
	}
}
