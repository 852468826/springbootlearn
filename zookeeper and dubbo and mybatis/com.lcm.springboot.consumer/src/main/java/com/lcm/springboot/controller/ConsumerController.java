package com.lcm.springboot.controller;



import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import com.lcm.springboot.api.IProvideService;

@RestController

public class ConsumerController {
	//dubbo远程引用
	/*@Reference(version="1.0.0")
	private ImybatisService imybatis;*/
	
	
	@Reference(version="2.0.0",interfaceClass=IProvideService.class)
	private IProvideService ip;
	
	/*@RequestMapping(value="/consumergetuser",method=RequestMethod.GET)
	public List<MUser> getUsers() 
	{
		return imybatis.getUsers();
	}*/
	
	@RequestMapping(value="/consumergetuser1",method=RequestMethod.GET)
	public List<com.lcm.springboot.bean.MUser> getUsers1() 
	{
		return ip.getUser();
	}
	
	
}
