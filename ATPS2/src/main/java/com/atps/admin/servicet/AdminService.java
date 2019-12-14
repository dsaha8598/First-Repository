package com.atps.admin.servicet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atps.admin.repository.AdminRepository;
import com.atps.usermanagement.domain.UserDomain;
import com.atps.usermanagement.entity.UserEntity;
import com.atps.usermanagement.mail.UserMailSender;
import com.atps.usermanagement.properties.AppProperties;
import com.example.generator.CustomGenerator;

/**
 * this is the service class for admin module
 * @author user
 *
 */
@Service
public class AdminService {

	@Autowired
	AdminRepository repository;
	@Autowired
	UserMailSender mailsender;
	@Autowired
	AppProperties properties;

	private static Logger LOGGER = LogManager.getLogger(AdminService.class);

	UserEntity userDetailsEntity = null, userId = null;
	String firstName = null, email = null, pswd = null;
	
	public UserEntity saveAdminDetails(UserDomain domain) {
		LOGGER.info("************saveUserDetails method of  UserService execution started************");
		userDetailsEntity = new UserEntity();
		BeanUtils.copyProperties(domain, userDetailsEntity);
		userDetailsEntity.setPswd(CustomGenerator.generateNumber());//rty678
		//userDetailsEntity.setRole("user");
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
		
		firstName = userId.getFirstName();LOGGER.info("************sendUserMail method of  UserService execution started************");
		email = userId.getEmail();
		pswd = userId.getPswd();
		mailsender.sendUserMail(firstName, email, pswd);
		LOGGER.info("************sendUserMail method of  UserService execution started************");
		return "";
	}
	
	/**
	 * getting records  from data base
	 * copying to list colllection
	 * @return listOfUsers
	 */
	/*public Map<Integer,List<UserDomain>> getAllAgencies(int pn){
		LOGGER.info("************getAllAgencies method of  UserService execution started************");
		int currentPageNo=pn;
		int pageSize=3;		
		PageRequest page = PageRequest.of(currentPageNo-1, pageSize);
		//to get the records on single page
		 Page<UserEntity> pageData = repository.findAll(page);
		 
		  //to get total no of pages
	        int totalPages=pageData.getTotalPages();
	        
	        //to get the data on the current page
	        List<UserEntity> listEntity=pageData.getContent();
	        
		ArrayList<UserDomain> listOfUsers=new ArrayList<UserDomain>(); 
		for(UserEntity entity:listEntity) {
			UserDomain users=new UserDomain();
			BeanUtils.copyProperties(entity,users);
			listOfUsers.add(users);
		}
		
		Map<Integer,List<UserDomain>> map=new HashMap<Integer,List<UserDomain>> ();
		map.put(totalPages,listOfUsers);
		LOGGER.info("************getAllAgencies method of  UserService execution ended************");
		return map;
	}*/
	
	public Page<UserEntity> getPageData(int pn) {
		int currentPageNo=pn;
		int pageSize=1;		
		PageRequest page = PageRequest.of(currentPageNo-1, pageSize);
		//to get the records on single page
		 Page<UserEntity> pageData = repository.findAll(page);
		return pageData;
	}
	public List<UserDomain> getAllAgencies(Page<UserEntity> pageData){
		List<UserEntity> listEntity=pageData.getContent();
        
		ArrayList<UserDomain> listOfUsers=new ArrayList<UserDomain>(); 
		for(UserEntity entity:listEntity) {
			UserDomain users=new UserDomain();
			BeanUtils.copyProperties(entity,users);
			listOfUsers.add(users);
		}
		return listOfUsers;
	}
	
	/**
	 * to deactivate th erecord present in data base
	 * @param id
	 * @return
	 */
	public UserEntity deactivate(Integer id) {
		Optional<UserEntity> optional=repository.findById(id);
		userDetailsEntity=optional.get();
		userDetailsEntity.setActiveStatus("N");
		userId=repository.save(userDetailsEntity);
		return userId;
	}
	
	public UserEntity activate(Integer id) {
		Optional<UserEntity> optional=repository.findById(id);
		userDetailsEntity=optional.get();
		userDetailsEntity.setActiveStatus("Y");
		userId=repository.save(userDetailsEntity);
		return userId;
	}
	
}
