package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.pojo.User;
import com.ssm.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	@RequestMapping("/createUser")
	public String createUser(HttpServletRequest request,Model model){
		User user = new User();
		user.setAge(1);
		user.setPassword("1");
		user.setUserName("fengxin");
		this.userService.createUser(user);
		return "success";
	}
}
