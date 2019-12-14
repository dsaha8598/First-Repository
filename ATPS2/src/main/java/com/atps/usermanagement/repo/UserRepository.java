package com.atps.usermanagement.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atps.usermanagement.entity.UserEntity;

@Repository
/**
 * this is the repository for userEntity
 * @author user
 *
 */
public interface UserRepository extends JpaRepository<UserEntity,Serializable>{

	@Query(value="select id from UserEntity where email=:email")
	public Integer getId(String email);
	
	@Query(value="select pswd from UserEntity where email=:email")
	public String getPassword(String email);
	
	@Query(value="select count(1) from UserEntity where email=:email")
	public Integer getEmailCount(String email);
			
}
