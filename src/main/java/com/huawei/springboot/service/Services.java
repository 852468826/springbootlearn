package com.huawei.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.huawei.springboot.dao.DaoService;
import com.huawei.springboot.entries.User;



@Service

public class Services {
	
	@Autowired
	private DaoService dao;
	
	public Services() {
		super();
		
	}

	public String getName() 
	{
		
		
		
		return "boy";
	}
	
	
	public User getjj() 
	{
		User user = new User();
		user.setName("dd");
		user.setAge(12);
		return user;
	}
}
