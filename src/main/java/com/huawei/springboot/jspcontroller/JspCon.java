package com.huawei.springboot.jspcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class JspCon {

	@RequestMapping(value="/jsppag")
	
	public String getjsp(Model mode) 
	{
		
		mode.addAttribute("name", "ddddddd");
		return "index";
		
	}
	
}
