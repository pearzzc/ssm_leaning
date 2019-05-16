package com.mystore3.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Goods {
	private Integer g_id;
	private String g_name;
	private Double g_price;
	private String g_image;
	private String g_desc;
	private Integer g_is_hot;
	private Integer g_cid;
	@Override
	public String toString() {
		return "Goods [g_id=" + g_id + ", g_name=" + g_name + ", g_price=" + g_price + ", g_image=" + g_image
				+ ", g_desc=" + g_desc + ", g_is_hot=" + g_is_hot + ", g_cid=" + g_cid + "]";
	}
	
	
	
}
