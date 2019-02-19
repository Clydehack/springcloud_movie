package com.template.ie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringcloudMovieApplication {

	/**
	 * restTemplate - 调用api方法
	
	@Bean
	@LoadBalanced	// 添加ribbon，具备负载均衡能力
	public RestTemplate restTemplate() {
		return new RestTemplate();
	} */
	
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudMovieApplication.class, args);
	}

}