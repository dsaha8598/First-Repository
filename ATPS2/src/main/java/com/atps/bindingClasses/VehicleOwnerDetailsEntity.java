package com.atps.bindingClasses;

 

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
/**
 * to make the class as entity class
 * @author user
 *
 */
@Entity
/**
 * mapping the classs with table
 * @author user
 *
 */
@Table(name="VEHICLE_OWNER_DTLS")
/**
 * entity class for VehicleOwnerDetailsEntity
 * @author user
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VehicleOwnerDetailsEntity{

	@Id
	@GeneratedValue
	@Column(name="VEHICLE_OWNER_ID") 
	private int vehicle_dtl_id;
	
	@Column(name="FIRST_NAME")
	private String first_name;
	
	
	
	@Column(name="LAST_NAME")
	private String last_name;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="PHNO")
	private long phno;
	
	/*@Column(name="VEHICLE_OWNER_ID")
	private int vehicle_owner_id;*/
	

	@CreationTimestamp
	private LocalDateTime create_dt;
	
	@UpdateTimestamp
	private LocalDateTime update_dt;

}
