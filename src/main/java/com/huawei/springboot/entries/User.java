package com.huawei.springboot.entries;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class User {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	
}
