package com.electricity.billing.model;

import java.time.LocalDate;
import java.util.List;

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
	public Long consumerId;

	@Column(name = "customer_name")
	public String fullName;

	@Column(name = "phone_no")
	public String mobileNumber;

	@Column(name = "user_Age")
	public LocalDate dateOfBirth;

	@Column(name = "address")
	public String address;

	@Column(name = "consumer_Type")
	public String consumerType;

	@Column(name = "email_id")
	public String emailId;

	@Column(name = "user_password")
	public String password;

}