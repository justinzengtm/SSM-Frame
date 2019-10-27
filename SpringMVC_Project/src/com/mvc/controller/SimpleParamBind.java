package com.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.mvc.model.User;

@Controller
@RequestMapping("/user")
public class SimpleParamBind {
	private UserService userService = new UserService();

	@RequestMapping(value="/queryUserById", method= {RequestMethod.GET})
	public String queryUserById(Integer id, Model model) throws Exception {
		// 查询用户信息
		List<User> userList = userService.queryUserById(id);
		// 通过形参中的model将数据传到页面
		model.addAttribute("userList", userList);

		return "users/userList"; // 返回视图
	}
	
	// 模拟Service内部类
	class UserService {
		public List<User> queryUserById(Integer id) {
			List<User> userList = new ArrayList<User>();
			
			User user1 = new User();
			user1.setId(1);
			user1.setUsername("理莎");
			user1.setEmail("9497@126.com");
			user1.setGender("女");
			user1.setProvince("广东省");
			user1.setCity("广州市");
			
			User user2 = new User();
			user2.setId(2);
			user2.setUsername("张三");
			user2.setEmail("9527@126.com");
			user2.setGender("男");
			user2.setProvince("山西省");
			user2.setCity("太原市");
			
			User user3 = new User();
			user3.setId(3);
			user3.setUsername("赵敏");
			user3.setEmail("8421@126.com");
			user3.setGender("女");
			user3.setProvince("江苏省");
			user3.setCity("南京市");
			
			switch(id) {
				case 1 : userList.add(user1);
					break;
				case 2 : userList.add(user2);
					break;
				case 3 : userList.add(user3);
					break;
			}

			return userList;
		}
	}
}
