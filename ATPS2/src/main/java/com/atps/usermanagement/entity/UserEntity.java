package com.atps.usermanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

/**
 * this is to make the class as entity 
 * @author user
 *
 */
@Entity
@Data
/**
 * this is to map the class with database table
 * @author user
 *
 */
@Table(name="ATPS_USER_REGISTRATION")

public class UserEntity {

	 @Id
	    @GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
	            @org.hibernate.annotations.Parameter(name = "sequenceName", value = "sequence"),
	            @org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
	    })
	    @GeneratedValue(generator = "sequence", strategy=GenerationType.SEQUENCE)
	 @Column(name="id")
	private Integer id;
	 
    @Column(name="FIRSTNAME")
	private String firstName;
    
    @Column(name="LASTNAME")
	private String lastName;
    
    @Column(name="EMAIL")
	private String email;
    
    @Column(name="PHNO")
	private Long phNo; 
    
    @Column(name="DOB")
	private Date dob;
    
    @Column(name="GENDER")
	private String gender;
    
    @Column(name="PSWD")
	private String pswd;
    
    @Column(name="ROLE")
	private String role;
    
    @Column(name="LOCKSTATUS")
	private String lockStatus;
    
    @Column(name="ACTIVESTATUS")
    private String activeStatus;
    
    @CreationTimestamp
	private Date createDate;
    
    @UpdateTimestamp
	private Date updatedDate;
}
