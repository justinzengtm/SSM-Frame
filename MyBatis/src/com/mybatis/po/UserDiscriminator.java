package com.mybatis.po;

import java.util.HashMap;

public class UserDiscriminator {
	private int id;
	private String username; //顾客姓名
	private String gender; //性别
	private String email; //电子邮件
	HashMap<String, String> userInfo = new HashMap<String, String>();

	public UserDiscriminator() {
		
	}
	
	public UserDiscriminator(int id, String username, String gender, 
			String email, HashMap userInfo) {
		this.id = id;
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.userInfo = userInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public HashMap<String, String> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(HashMap<String, String> userInfo) {
		this.userInfo = userInfo;
	}
	
}
