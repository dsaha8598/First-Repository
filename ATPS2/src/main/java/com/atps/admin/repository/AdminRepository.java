package com.atps.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atps.usermanagement.entity.UserEntity;

/**
 * thiss is the repository for admin module
 * @author user
 *
 */
@Repository
public interface AdminRepository extends JpaRepository<UserEntity,Serializable>{
	

}
