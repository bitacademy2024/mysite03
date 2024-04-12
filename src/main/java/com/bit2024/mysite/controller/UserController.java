package com.bit2024.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2024.mysite.repository.UserRepository;
import com.bit2024.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/joinform")
	public String joinform() {
		return "user/joinform";
	}

	@RequestMapping("/join")
	public String join(UserVo vo) {
		userRepository.insert(vo);
		return "redirect:/user/joinsuccess";
	}

	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping("/loginform")
	public String loginform() {
		return "user/loginform";
	}
	
	
}
