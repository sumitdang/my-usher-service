package com.usher.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usher.pojo.db.User;
import com.usher.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

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
	 * This method is used to fetch all users from database
	 *
	 * @return List<User>
	 * @throws Exception
	 */
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		log.info("GET /users API to fetch all users");
		List<User> users = userRepo.getAllUsers();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	/**
	 * This method is used to fetch user from database using email
	 *
	 * @return User
	 * @throws Exception
	 */
	@GetMapping("/users/{email}/")
	public ResponseEntity<User> getUserByEmail(@ApiParam(value = "email", required = true) @PathVariable String email) {
		log.info("GET /users API to fetch all users");
		User user = userRepo.getUserByEmail(email);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	/**
	 * End-point for adding a new user. It inserts record into user table
	 * 
	 * @param user
	 * 
	 * @return ResponseEntity<User>
	 */
	@PostMapping("/users")
	public ResponseEntity<User> addNewuser(@RequestBody User user) {
		log.info("POST /users/");

		if (user == null)
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		else {
			User savedUser = userRepo.saveAndFlush(user);
			if (savedUser == null) {
				return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
			} else {
				return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
			}

		}

	}

}
