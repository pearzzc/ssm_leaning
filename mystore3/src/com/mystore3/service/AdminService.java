package com.mystore3.service;

import com.mystore3.dao.AdminDao;
import com.mystore3.domain.Admin;

public class AdminService {

	public Admin login(String name, String password) throws Exception {
		AdminDao adminDao = new AdminDao();
		Admin admin =adminDao.checkadmin(name,password); 
		if(admin==null) {
			throw new Exception("�û������������");
		}else {
			return admin;
		}
	}

}
