package com.mybatis.po;

public class UserDiscriminator1 {
	private int id;
	private String username; //顾客姓名
	private String gender; //性别
	private String email; //电子邮件
	private String province; //省会
	private String city; //城市
	
	public UserDiscriminator1() {
		
	}
	
	public UserDiscriminator1(int id, String username, String gender, String email, 
			String province, String city) {
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.province = province;
		this.city = city;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
