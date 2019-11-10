package com.mvc.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.model.User;
import com.mvc.service.UserServiceImpl;
import com.mvc.validator.group.UserGroup1;

@Controller
@RequestMapping("user")
public class validationControllerTest {
	private UserServiceImpl userService = new UserServiceImpl();
	@RequestMapping("validationByCondition")
	public String queryUserByCondition(Model model, 
			@Validated(value=UserGroup1.class) User user, 
			BindingResult bindingResult) {
		// 保存校验错误信息
		List<ObjectError> ErrorList = null;
		if (bindingResult.hasErrors()) {
			ErrorList = bindingResult.getAllErrors();
			for (ObjectError objectError : ErrorList) {
				System.out.println(objectError.getDefaultMessage());
			}
		}
		
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
		model.addAttribute("ErrorList", ErrorList);
		
		return "users/validateUser"; // 返回视图
	}
}
