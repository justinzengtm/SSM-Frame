package com.mvc.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.model.User;
import com.mvc.service.UserServiceImpl;

@Controller
@RequestMapping("user")
public class PackParamBind {
	private UserServiceImpl userService = new UserServiceImpl();
	
	@RequestMapping("findUserByCondition")
	public String queryUserByCondition(Model model, User user) {
		List<User> userList = null;
		
		if(user == null || (user.getUsername() == null && user.getGender() == null)) {
			// 如果查询框中两个查询条件都为空，则默认查询所有顾客数据
			userList = userService.queryUserList();
		} else {
			// 否则进行条件查询
			userList = userService.queryUserByCondition(user);
		}
		
		// model数据传到页面
		model.addAttribute("userList", userList);
		
		return "users/queryUser"; // 返回视图
	}
	
}
