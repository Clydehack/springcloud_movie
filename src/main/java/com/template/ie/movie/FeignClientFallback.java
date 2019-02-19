package com.template.ie.movie;

import org.springframework.stereotype.Component;

import com.template.ie.movie.model.User;

/**
 * 回退类 - 回退类需要实现FeignClient接口，用于熔断器Hystrix
 */
@Component
public class FeignClientFallback implements UserFeignClient {

	public User findById(Long id) {
		User user =new User();
		user.setId(-1L);
		user.setUsername("默认用户");
		return user;
	}
}