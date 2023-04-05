package org.hj.controller;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controller 어너테이션
@Controller	
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
// 접근제어자  반환타입  메서드명(매개변수, 매개변수)
	public String home(Locale locale, Model model) {// url에서 보내는 인수 없음 - 지금은 쓰임이 없음
		return "home";	// /WEB-INF/views/home.jsp를 실행해라!
	}
	@RequestMapping(value = "/drop", method = RequestMethod.GET)
	// 접근제어자  반환타입  메서드명(매개변수, 매개변수)
		public String drop() {
			return "drop";
		}
		
	
	
}
