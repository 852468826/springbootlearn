package com.lcm.springboot.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lcm.springboot.api.IProvideService;
import com.lcm.springboot.bean.MUser;


@RestController

public class ProviderController {

	@Autowired
	private IProvideService ipProvideService;
	
	@RequestMapping(value="provider",method=RequestMethod.GET)
	public List<MUser> getUsers()
	{
		return ipProvideService.getUser();
	}
	
}
