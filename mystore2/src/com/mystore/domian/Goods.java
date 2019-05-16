package com.mystore.domian;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Goods {
	private int id;
	private  String name;
	private Double price;
	private String image;
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}
	
}
