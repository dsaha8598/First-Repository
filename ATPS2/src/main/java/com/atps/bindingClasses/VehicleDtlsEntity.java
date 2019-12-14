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

import lombok.Data;

@Data

@Entity

@Table(name="VEHICLE_DTLS")
/**
 * entity class for VehicleDtls
 * @author user
 *
 */
public class VehicleDtlsEntity {

	/**
	 * to make the column as primary key column
	 */
	@Id
	@GeneratedValue
	@Column(name="VEHICLE_DTL_ID")
	private int vehicle_dtl_id;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicle_type;
	
	@Column(name="MFG_YEAR")
	private int mfg_year;
	
	@Column(name="VEHICLE_BRAND")
	private String vehicle_brand;
	
	
	@CreationTimestamp
	private Date create_dt;
	
	@UpdateTimestamp
	private Date update_dt;
	
	@Column(name="VEHICLE_OWNER_ID" ,updatable=false,insertable=false)
    private int vehicle_owner_id;
	
	/**
	 * these annotations are used to perform association mapping
	 */
	@OneToOne(fetch=FetchType.LAZY)
	  
	@JoinColumn(name="VEHICLE_OWNER_ID",nullable=false,referencedColumnName="VEHICLE_OWNER_ID")
	private VehicleOwnerDetailsEntity vowner;
}
