package com.huawei.springboot.mybatiscontroller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	@ResponseBody
	public Object getUsers() {
		
		// 线程调用查询学生
		Runnable run = new Runnable() {

			@Override
			public void run() {
				imybatis.getUsers();
			}
		};
		// 多线程测试缓存穿透
		ExecutorService ex = Executors.newFixedThreadPool(25);

		for (int i = 0; i < 10000; i++) {
			ex.submit(run);

		}
		return imybatis.getUsers();

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

		return imybatis.createUser(muser);

	}
}
