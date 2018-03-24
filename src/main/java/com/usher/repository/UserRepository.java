package com.usher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usher.pojo.db.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from usher.user", nativeQuery = true)
	public List<User> getAllUsers();
}