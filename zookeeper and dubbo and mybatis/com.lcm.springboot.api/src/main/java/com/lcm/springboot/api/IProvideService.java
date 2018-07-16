package com.lcm.springboot.api;

import java.util.List;

import com.lcm.springboot.bean.MUser;

public interface IProvideService {
	public List<MUser> getUser();
}
