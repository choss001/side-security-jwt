package com.security.jss.web;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

  @RequestMapping("/login")
  public ModelAndView login() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("jss/login");
    return mav;
  }

  @RequestMapping("/auth")
  public String auth() {
    return "success";
  }

  @RequestMapping("/test/logout")
  public ModelAndView test(HttpServletResponse response, HttpServletRequest request) {
    Cookie[] myCookies = request.getCookies();
    for (int i = 0; i < myCookies.length; i++) {

      System.out.println(i + "cookie Name : " + myCookies[i].getName());
      System.out.println(i + "cookie Value: " + myCookies[i].getValue());
      myCookies[i].setMaxAge(0);
      myCookies[i].setPath("/");
      response.addCookie(myCookies[i]);
    }


    ModelAndView mav = new ModelAndView();
    mav.setViewName("/jss/testPage");
    return mav;
  }

  @GetMapping("/test/base64")
  public byte[] testBase64() {
    String text = "20180530151620700:9C902E58-0CD4-3D1C-A379-FC7815393EB2";
    byte[] targetBytes = text.getBytes();
    Encoder encoder = Base64.getEncoder();
    byte[] encodedBytes = encoder.encode(targetBytes);
    Decoder decoder = Base64.getDecoder();
    byte[] decodedBytes = decoder.decode(encodedBytes);
    System.out.println("인코딩 전 : " + text);
    System.out.println("인코딩 text : " + new String(encodedBytes));
    System.out.println("디코딩 text : " + new String(decodedBytes));

    return encodedBytes;
  }

}
