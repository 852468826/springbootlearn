package com.huawei.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.huawei.springboot.entries.User;
import com.huawei.springboot.service.Services;

@Controller
public class HelloController {

	@Autowired
	private Services ser;
	@RequestMapping(value = "/hello" )
	@ResponseBody
	public String name() {
		System.out.println("hello");
		
		System.out.println(ser.getName());
		
		
		return "hello";
	}
	
//	@RequestMapping(value = "/hello1",produces="text/plain;charset=UTF-8" )
	@ResponseBody
	@RequestMapping(value="hello1")
	public User gg() {
		System.out.println("hello");
		
		System.out.println(ser.getjj());
		
		
		return ser.getjj();
	}
}
