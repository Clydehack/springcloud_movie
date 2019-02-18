package com.template.ie.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.template.ie.movie.model.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User queryUserById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://localhost:8080/" + id, User.class);
	}
}