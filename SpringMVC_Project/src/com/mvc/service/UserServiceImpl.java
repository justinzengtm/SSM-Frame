package com.mvc.service;

import java.util.ArrayList;
import java.util.List;
import com.mvc.model.User;

public class UserServiceImpl implements UserService {
	public List<User> userList = null;
	public List<User> init() {
		if(userList == null) {
			userList = new ArrayList<User>();
			
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
			
			userList.add(user1);
			userList.add(user2);
			userList.add(user3);
			
			return userList;
		} else {
			return userList;
		}
	}
	@Override
	public List<User> queryUserList() {
		init();
		
		return userList;
	}
	
	@Override
	public List<User> queryUserByCondition(User user) {
		init();
		String name = user.getUsername();
		String gender = user.getGender();
		List<User> queryList = new ArrayList<User>();
		
		User u = null;
		for(int i=0; i<userList.size(); i++) {
			u = userList.get(i);
			if((!name.equals("") && u.getUsername().contains(name)) && 
					(!gender.equals("") && u.getGender().contains(gender))) {
				queryList.add(u);
			}
		}
		
		return queryList;
	}
	
	@Override
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
