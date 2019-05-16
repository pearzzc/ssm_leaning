package com.xuexi.domian;

import java.util.Arrays;
/*
 * 设置关键的domain 用于封装从表单获取的相关参数及信息
 */
public class User {
	
	private String name;
	private String password;
	private String gender;
	private String[] hobby;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", gender=" + gender + ", hobby="
				+ Arrays.toString(hobby) + "]";
	}
}
