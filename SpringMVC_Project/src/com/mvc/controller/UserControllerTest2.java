package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestHandler;
import com.mvc.model.User;

public class UserControllerTest2 implements HttpRequestHandler {
	private UserService userService = new UserService();
	
	@Override
	public void handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 数据模型Model,模拟获取用户信息列表
		List<User> userList = userService.queryUserList();
		// 设置数据模型
		request.setAttribute("userList", userList);
		// 设置转发视图
		request.getRequestDispatcher("/WEB-INF/jsp/users/userList.jsp").forward(request, response);
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
