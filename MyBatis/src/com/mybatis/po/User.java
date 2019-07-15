package com.mybatis.po;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String gender;
	private String email;
	private String province;
	private String city;
	private Date birthday;
	private int age;
	
	public User() {
		System.out.println("进入目标类无参数构造方法....");
	}
	// 构造方法初始化
	public User(String username, String password, String gender, String email, String province,
			String city, Date birthday) {
		super();
		System.out.println("进入目标类有参数构造方法....");
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.province = province;
		this.city = city;
		this.birthday = birthday;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
