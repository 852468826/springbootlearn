package com.huawei.springboot.mybaitservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.huawei.springboot.entries.MUser;
import com.huawei.springboot.mapper.MUserMapper;

@Service
public class MybatisImp implements ImybatisService {

	@Autowired
	public MUserMapper muserMapper;
	@Override
	public List<MUser> getUsers() {
		
		return muserMapper.getAll();
	}
	@Override
	public boolean updateUser(MUser muser) {
     
		int result = muserMapper.updateByPrimaryKey(muser);
		//事务测试
		int a = 10/0;
		if (result > 0) 
		{
			return true;
		}
		return false;
	}
	@Override
	public boolean createUser(MUser muser) {
		int result = muserMapper.insert(muser);
		if (result > 0) 
		{
			return true;
		}
		return false;
	}
	@Override
	public MUser getUser(String id) {
		
		return muserMapper.selectByPrimaryKey(id);
	}
	

}
