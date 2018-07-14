package com.huawei.springboot.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.springboot.entries.MUser;
import com.huawei.springboot.mybaitservice.ImybatisService;


@RestController
public class RestfulController {

	@Autowired
	private ImybatisService i;
	
	/**
	 * restful 接口 @PathVariable注解读取/boot/user/{id}"中id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/boot/user/{id}")
	public MUser getUser(@PathVariable("id") String id)
	{
		System.out.println("kk");
		return i.getUser(id);
	}
}
