package com.security.jss.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String auth() {
		System.out.println("여기 들어오는거 맞지?111");
		return "success";
	}

	@RequestMapping("/test/logout")
	public ModelAndView test(HttpServletResponse response, HttpServletRequest request) {
		Cookie[] myCookies = request.getCookies();
		for(int i = 0; i < myCookies.length; i++) {

    		System.out.println(i + "번째 쿠키 이름: " +myCookies[i].getName());
    		System.out.println(i + "번째 쿠키 값: " +myCookies[i].getValue());
			myCookies[i].setMaxAge(0);
			myCookies[i].setPath("/");
			response.addCookie(myCookies[i]);
		}
		

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/jss/testPage");
		return mav;
	}

}
