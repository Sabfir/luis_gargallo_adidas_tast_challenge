package com.adidaschallenge.AdidasChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidaschallenge.AdidasChallenge.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	
	UserEntity findByUserName(String userName);
}
