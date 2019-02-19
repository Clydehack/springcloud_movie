package com.template.ie.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.template.ie.movie.model.User;

@RestController
public class MovieController {

	private Logger logger = LoggerFactory.getLogger(MovieController.class); 
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancedClient;
	
	/**
	 * restTemplate - 调用测试
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User queryUserById(@PathVariable Long id) {
		logger.info("begin" + "end");
		return this.restTemplate.getForObject("http://user/ant/" + id, User.class);
	}
	
	/**
	 * 客户端负载均衡 - 调用测试
	 */
	@RequestMapping(value = "/log-instance", method = RequestMethod.GET)
	public void logUserInstance() {
		// 
		ServiceInstance serviceInstance = this.loadBalancedClient.choose("user");
		logger.info("begin" + "{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort() + "end");
	}
}