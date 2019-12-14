package com.atps.bindingClasses;


import java.util.Date;

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
@Table(name="VEHICLE_REG_DETAILS")
/**
 * entity class for VehicleOwnerDetailsEntity
 * @author user
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class VehiclesRegDtlsEntity{

	@Id
	@GeneratedValue
	@Column(name="VEHICLE_REG_ID")
	private int vehicle_reg_id;
	
	@Column(name="REG_DATE")
	private Date reg_date;
	
	@Column(name="REG_CENTER")
	private String reg_center;
	
	@CreationTimestamp
	private Date create_dt;
	
	@UpdateTimestamp
	private Date update_dt;
	
	@Column(name="VEHICLE_REG_NUM")
	private String vehicle_reg_num;
	
	@Column(name="VEHICLE_OWNER_ID" ,updatable=false,insertable=false)
    private int vehicle_owner_id;
	
	@OneToOne(fetch=FetchType.LAZY)
	  
	@JoinColumn(name="VEHICLE_OWNER_ID",nullable=false,referencedColumnName="VEHICLE_OWNER_ID")
	private VehicleOwnerDetailsEntity vowner;
}
