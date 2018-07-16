package com.lcm.springboot.interceptorconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.lcm.springboot.interceptor.MyInterceptor;

/**
 * 拦截器添加到webmv中
 * @author aaaaa
 *
 */
@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//注册添加拦截器
		InterceptorRegistration  reg =registry.addInterceptor(new MyInterceptor());
		//需要拦截的路径
		String[] addPathPatterns = {"/consumergetuser1"};
		reg.addPathPatterns(addPathPatterns);
		
		//不需要拦截的路径
		String[] excludePathPatterns = {"/consumergetuser"};
		reg.excludePathPatterns(excludePathPatterns);
		super.addInterceptors(registry);
	}

}
