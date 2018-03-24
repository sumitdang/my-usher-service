package com.usher.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usher.pojo.db.User;
import com.usher.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = UsherController.BasePath + "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "User", description = "Endpoint pertaining to Users")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Resource
	private Environment environment;

	@Autowired
	private UserRepository userRepo;

	/**
	 * This method is used to fetch all domains from database
	 *
	 * @return List<User>
	 * @throws Exception
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ApiOperation(value = "Fetch all Domains")
	public List<User> getUsers() {
		log.info("GET /domains API to fetch all domains");
		List<User> users = userRepo.getAllUsers();

		return users;
	}

}
