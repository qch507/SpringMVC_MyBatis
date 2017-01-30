package com.qiuch.springmybatis.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qiuch.springmybatis.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;

	@RequestMapping("/userinfo")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("userinfo");
		mov.addObject("userInfo", userService.getUser());
		return mov;
	}
}
