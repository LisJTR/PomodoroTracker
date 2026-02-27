package com.lis.pomodoro.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lis.pomodoro.users.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
