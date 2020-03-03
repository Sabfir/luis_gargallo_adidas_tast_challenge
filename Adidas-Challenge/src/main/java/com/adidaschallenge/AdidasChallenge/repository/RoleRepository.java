package com.adidaschallenge.AdidasChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidaschallenge.AdidasChallenge.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findByRoleName(String roleName);
}
