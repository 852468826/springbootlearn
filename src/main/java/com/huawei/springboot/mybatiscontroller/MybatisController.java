package com.huawei.springboot.mybatiscontroller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.springboot.entries.MUser;

import com.huawei.springboot.mybaitservice.ImybatisService;

@RestController
public class MybatisController {
	public ImybatisService imybatis;

	public ImybatisService getImybatis() {
		return imybatis;
	}

	@Autowired
	public void setImybatis(ImybatisService imybatis) {
		this.imybatis = imybatis;
	}

	
	private RedisTemplate<Object, Object> redis;

	
	
	public RedisTemplate<Object, Object> getRedis() {
		return redis;
	}
	@Autowired
	public void setRedis(RedisTemplate<Object, Object> redis) {
		this.redis = redis;
		RedisSerializer<Object> re = new GenericJackson2JsonRedisSerializer();
		redis.setKeySerializer(re);
		
		redis.setValueSerializer(re);
	}


	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	@ResponseBody
	public List<MUser> getUsers() {
		List<MUser> user = (List<MUser>) redis.opsForValue().get("all");
		if (null == user || user.isEmpty()) {
			user = imybatis.getUsers();
			redis.opsForValue().set("all", user);
			return imybatis.getUsers();
		}

		return user;
	}

	@PutMapping(value = "/updateUser")
	@ResponseBody
	// 事务注解
	@Transactional
	public boolean updateUser(MUser muser) {

		muser.setId("12");
		muser.setAddress("29");
		muser.setName("ljd");
		muser.setAge(12);

		return imybatis.updateUser(muser);
	}

	@Transactional
	@PostMapping(value = "/createUser")
	@ResponseBody
	public boolean createUser(MUser muser) {
		String id = UUID.randomUUID().toString();

		
		muser.setId(id);
		muser.setAddress("29");
		muser.setName("lcm");
		muser.setAge(12);
		redis.opsForValue().set(id, muser);
		return imybatis.createUser(muser);

	}
}
