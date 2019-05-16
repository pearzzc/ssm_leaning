package com.mystore.domian;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class User {
	private String uid;
	private String uname;
	private String password;
	private String phone;
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", phone=" + phone + "]";
	}
}
