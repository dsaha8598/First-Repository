package com.atps.bindingClasses;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data

@Entity

@Table(name="VEHICLE_OWNER_ADRESS_DTLS")
/**
 * entity class for VehicleOwnerAdressDtls
 * @author user
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VehicleOwnerAdressDtlsEntity{

	@Id
	@GeneratedValue
	@Column(name="ADRESS_ID")
	private int adress_id;
	
	
	@Column(name="HNO")
	private String hno;
	
	@Column(name="STREET_NAME")
	private String street_name;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="ZIP_CODE")
	private int zip_code;
	
	@CreationTimestamp
	private LocalDateTime create_dt;
	
	@UpdateTimestamp
	private LocalDateTime update_dt;
	

	@Column(name="VEHICLE_OWNER_ID" ,updatable=false,insertable=false)
    private int vehicle_owner_id;
	
	@OneToOne(fetch=FetchType.LAZY)
	  
	@JoinColumn(name="VEHICLE_OWNER_ID",nullable=false,referencedColumnName="VEHICLE_OWNER_ID")
	private VehicleOwnerDetailsEntity vowner;

}
