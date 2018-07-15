package com.huawei.springboot.mybaitservice;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import com.huawei.springboot.entries.MUser;
import com.huawei.springboot.mapper.MUserMapper;

@Service
public class MybatisImp implements ImybatisService {

	/**
	 * common-logging \ log4j
	 */
	private static Logger log = Logger.getLogger(MybatisImp.class);  
	@Autowired
	public MUserMapper muserMapper;

	private RedisTemplate<Object, Object> redis;

	@Autowired
	public void setRedis(RedisTemplate<Object, Object> redis) {
		this.redis = redis;
		RedisSerializer<Object> re = new GenericJackson2JsonRedisSerializer();
		redis.setKeySerializer(re);

		redis.setValueSerializer(re);
	}

	public RedisTemplate<Object, Object> getRedis() {
		return redis;
	}

	@Override
	public List<MUser> getUsers() {

		// 此处有缓存穿透问题，如果有10000个人同时进入
		List<MUser> user = (List<MUser>) redis.opsForValue().get("all");
		

		// 双重检测锁，解决缓存穿透问题
		if (null == user || user.isEmpty()) {
			synchronized (this) {
				user = (List<MUser>) redis.opsForValue().get("all");

				if (null == user || user.isEmpty()) {
					log.info("select from database");
					System.out.println("select from database");
					user = muserMapper.getAll();
					redis.opsForValue().set("all", user);
					return user;
				}
			}
		}
		
		log.info("select from redis");
		System.out.println("select from redis");
		return user;

	}
	@Override
	public boolean updateUser(MUser muser) {
     
		int result = muserMapper.updateByPrimaryKey(muser);
		// 事务测试
		int a = 10 / 0;
		if (result > 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean createUser(MUser muser) {

		redis.opsForValue().set(muser.getId(), muser);
		int result = muserMapper.insert(muser);
		if (result > 0) {
			return true;
		}
		return false;
	}
	@Override
	public MUser getUser(String id) {
		
		return muserMapper.selectByPrimaryKey(id);
	}
	

}
