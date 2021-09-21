package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	public UserEntity findByFirstName(String firstName);
	public  UserEntity findByUsername(String username);
	public UserEntity findByEmailAndPassword(String email,String password);
}
