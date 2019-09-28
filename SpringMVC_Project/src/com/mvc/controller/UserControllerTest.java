package com.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.mvc.model.User;

// User Handler处理器
public class UserControllerTest implements Controller {
	private UserService userService = new UserService();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// 数据模型Model,模拟获取用户信息列表
		List<User> userList = userService.queryUserList();
		// 返回的ModelAndView对象
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", userList);
		// 指定视图View
		modelAndView.setViewName("/WEB-INF/jsp/users/userList.jsp");
		
		// 数据处理完后,返回视图和数据
		return modelAndView;
	}
	
	// 模拟Service内部类
	class UserService {
		public List<User> queryUserList() {
			List<User> userList = new ArrayList<User>();
			
			User user1 = new User();
			user1.setUsername("理莎");
			user1.setEmail("9497@126.com");
			user1.setGender("女");
			user1.setProvince("广东省");
			user1.setCity("广州市");
			
			User user2 = new User();
			user2.setUsername("张三");
			user2.setEmail("9527@126.com");
			user2.setGender("男");
			user2.setProvince("山西省");
			user2.setCity("太原市");
			
			User user3 = new User();
			user3.setUsername("赵敏");
			user3.setEmail("8421@126.com");
			user3.setGender("女");
			user3.setProvince("江苏省");
			user3.setCity("南京市");
			
			userList.add(user1);
			userList.add(user2);
			userList.add(user3);
			
			return userList;
		}
	}
}
