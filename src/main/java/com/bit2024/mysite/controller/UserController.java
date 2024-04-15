package com.bit2024.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
		@RequestParam(value="email", required=true, defaultValue="") String email,
		@RequestParam(value="password", required=true, defaultValue="") String password,
		Model model) {
		UserVo authUser = userRepository.findByEmailAndPassword(email, password);
		if(authUser == null) {
			model.addAttribute("email", email);
			model.addAttribute("result", "fail");
			
			return "user/login";
		}
		
		return "redirect:/";
	}
	
}
