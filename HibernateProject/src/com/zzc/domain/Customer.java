package com.zzc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Customer {
    private long cust_id;
    private String cust_name;
    private String cust_sourse;
    private String cust_industry;
    private String cust_level;
    private String cust_phone;
    private String cust_mobile;

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_sourse='" + cust_sourse + '\'' +
                ", cust_industry='" + cust_industry + '\'' +
                ", cust_level='" + cust_level + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                '}';
    }
}
