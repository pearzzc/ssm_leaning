package com.mystore3.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Admin {
	private String id;
	private String name;
	private String password;
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
}
