package com.bit2024.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2024.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/joinform")
	public String joinform() {
		return "user/joinform";
	}

	@ResponseBody
	@RequestMapping("/join")
	public String join(UserVo vo) {
		System.out.println(vo);
		return "UserController:join";
	}

	@RequestMapping("/loginform")
	public String loginform() {
		return "user/loginform";
	}
	
	
}
