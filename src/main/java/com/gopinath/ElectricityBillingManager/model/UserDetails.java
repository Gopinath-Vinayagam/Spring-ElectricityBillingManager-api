package com.gopinath.ElectricityBillingManager.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "electricity_registration_details")
@Data
@ToString
public class UserDetails {
	@Id
	@Column(name = "customer_id")
	public Long ConsumerId;

	@Column(name = "customer_name")
	public String FullName;

	@Column(name = "user_name")
	public String UserName;

	@Column(name = "phone_no")
	public String MobileNumber;

	@Column(name = "user_Age")
	public String DateOfBirth;

	@Column(name = "address")
	public String Address;

	@Column(name = "consumer_Type")
	public String ConsumerType;

	@Column(name = "email_id")
	public String EmailId;

	@Column(name = "PASSWORD")
	public String Password;
}