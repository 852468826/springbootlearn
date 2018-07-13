package com.huawei.springboot.myconfigtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyConfig{

//	@Value("${lcm.test}")
//	private String teString;
//	@Value("${lcm.test1}")
//	private String teString1;
	
	@Autowired
	private MapperConfig map;
	
//	@RequestMapping(value="/boot",produces="text/plain;charset=UTF-8")
//	
//	@ResponseBody
	@GetMapping("/boot")
	@ResponseBody
	public String getboot() 
	{
		
		return map.getTest()+map.getTest1();
	}
	
	@GetMapping("/boot1")
	@ResponseBody
	public String getboot1() 
	{
		
		return "222";
	}
}
