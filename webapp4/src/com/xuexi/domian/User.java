package com.xuexi.domian;

import java.util.Arrays;
/*
 * ���ùؼ���domain ���ڷ�װ�ӱ���ȡ����ز�������Ϣ
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
