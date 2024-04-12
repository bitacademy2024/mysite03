package com.bit2024.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/user/joinform")
	public String joinform() {
		return "/WEB-INF/views/user/joinform.jsp";
	}
}
