package com.atps.usermanagement.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atps.usermanagement.domain.UserDomain;
import com.atps.usermanagement.entity.UserEntity;
import com.atps.usermanagement.mail.UserMailSender;
import com.atps.usermanagement.properties.AppProperties;
import com.atps.usermanagement.repo.UserRepository;
import com.example.generator.CustomGenerator;

@Service
/**
 * this is the service class
 * 
 * @author user
 *
 */
public class UserService {
	/**
	 * injecting repository object to service class
	 */
	@Autowired
	UserRepository repository;
	@Autowired
	UserMailSender mailsender;
	@Autowired
	AppProperties properties;

	private static Logger LOGGER = LogManager.getLogger(UserService.class);

	UserEntity userDetailsEntity = null, userId = null;
	String firstName = null, email = null, pswd = null;

	/**
	 * recieving the mail id from controller
	 * sending the mail into data base
	 * @param email
	 * @return
	 */
	public Integer checkEmail(String email) {
		int count=repository.getEmailCount(email);
		return count;
	}
	/**
	 * 
	 * @param domain
	 * @return userId
	 */
	public UserEntity saveUserDetails(UserDomain domain) {
		LOGGER.info("************saveUserDetails method of  UserService execution started************");
		userDetailsEntity = new UserEntity();
		BeanUtils.copyProperties(domain, userDetailsEntity);
		userDetailsEntity.setPswd(CustomGenerator.generateNumber());//rty678
		userDetailsEntity.setRole("user");
		userDetailsEntity.setLockStatus("locked");
		userDetailsEntity.setActiveStatus("Y");
		userId = repository.save(userDetailsEntity);
		LOGGER.info("************saveUserDetails method of  UserService execution ended************");
		return userId;
	}

	/**
	 * this is to send the name,email,password to mail sender class
	 * 
	 * @return
	 */
	public String sendUserMail() {
		LOGGER.info("************sendUserMail method of  UserService execution started************");
		firstName = userId.getFirstName();
		email = userId.getEmail();
		pswd = userId.getPswd();
		mailsender.sendUserMail(firstName, email, pswd);
		LOGGER.info("************sendUserMail method of  UserService execution started************");
		return "";
	}

	/**
	 * this method sends the data to repository to mdify the password
	 * 
	 * @param domain
	 */
	public String updatePasswordByEmail(UserDomain domain) {
		LOGGER.info("************updatePasswordByEmail method of  UserService execution started************");
		String email = domain.getEmail();
		Integer id = repository.getId(email);
		Optional<UserEntity> optional = repository.findById(id);
		userDetailsEntity = optional.get();
		if (domain.getPswd().equals(userDetailsEntity.getPswd())) {
			LOGGER.info("************if block of updatePasswordByEmail method executed************");
			userDetailsEntity.setPswd(domain.getUpswd());
			userDetailsEntity.setLockStatus("unlocked");
			repository.save(userDetailsEntity);
			return "success";
		} else {
			LOGGER.info("************else block of updatePasswordByEmail method executed************");
			return "fail";
		}

	}

	/**
	 * it is used to get the password from the databse and to validate with the user
	 * entered password
	 * 
	 * @param domain
	 * @return String
	 */

	public String validateLogIn(UserDomain domain) {
		LOGGER.info("************validateLogIn method of  UserService execution started************");
		String email = domain.getEmail();
		String password = domain.getPswd();
		if(email.equals(properties.getMessages().get("userName")) &&password.equals(properties.getMessages().get("password"))) {
			return "success";
		}
		Integer id = repository.getId(email);
		// checking id for not null
		if (id == null) {
			return "fail";
		}
		Optional<UserEntity> optional = repository.findById(id);
		userDetailsEntity = optional.get();
		// String returnedPassword=repository.getPassword(email);
		String returnedPassword = userDetailsEntity.getPswd();
		String lockStatus = userDetailsEntity.getLockStatus();
		String activeStatus=userDetailsEntity.getActiveStatus();
		if (password.equals(returnedPassword) && lockStatus.equals("unlocked") &&activeStatus.equals("Y")) {
			LOGGER.info("************if block of validateLogIn method executed************");
			return "success";
		} else {
			LOGGER.info("************else block of validateLogIn method executed************");
			return "fail";
		}
	}//method
	
	/**
	 * recieving model class object
	 * retrieves email by calling getPassword() of UserRepository
	 * if retrievedPassword is not null calls mailWithUpdatedPassword() to send the email 
	 * @param domain
	 * @return success 
	 * @return null
	 */
	public String getPassword(UserDomain domain) {
		LOGGER.info("************getPassword method of  UserService execution started************");
		String email=domain.getEmail();
		String retrievedPassword=repository.getPassword(email);
		if(retrievedPassword!=null) {
			LOGGER.info("************if block of getPassword method executed************");
			mailsender.mailWithUpdatedPassword(retrievedPassword, email);
		return "success";
		}
		return null;
		
	}
}
