package com.atps.usermanagement.domain;

import java.util.Date;

import lombok.Data;

@Data
/**
 * this class is to hold the form data 
 * @author user
 *
 */

public class UserDomain {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Long phNo; 
	private Date dob;
	private String gender;
	private String cpswd;
	private String pswd;
	private String upswd;
	private String role;
	private String activeStatus;
	private String lockStatus;
	private Date createDate;
	private Date updatedDate;

}
