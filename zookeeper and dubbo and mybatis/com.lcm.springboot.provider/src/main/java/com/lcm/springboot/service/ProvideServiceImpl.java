package com.lcm.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcm.springboot.api.IProvideService;
import com.lcm.springboot.bean.MUser;
import com.lcm.springboot.mapper.MUserMapper;
@org.springframework.stereotype.Service
@Service(version="2.0.0",interfaceClass=IProvideService.class)
public class ProvideServiceImpl implements IProvideService {

	@Autowired
	private MUserMapper muserMapper;
	
	public List<MUser> getUser() {
		
		return muserMapper.getAll();
	}

}
