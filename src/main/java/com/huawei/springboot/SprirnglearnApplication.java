package com.huawei.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//事务注解
@EnableTransactionManagement
public class SprirnglearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprirnglearnApplication.class, args);
	}
}
