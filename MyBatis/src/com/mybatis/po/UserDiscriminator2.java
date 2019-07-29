package com.mybatis.po;

import java.util.Date;

public class UserDiscriminator2 {
	private int id;
	private String username; //顾客姓名
	private String gender; //性别
	private String email; //电子邮件
	private Date birthday; //生日
	private int age; //年龄
	
	public UserDiscriminator2() {
		
	}
	
	public UserDiscriminator2(int id, String username, String gender, String email, 
			Date birthday, int age) {
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.birthday = birthday;
		this.age = age;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
