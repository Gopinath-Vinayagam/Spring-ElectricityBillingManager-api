package com.gopinath.ElectricityBillingManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
@Entity
@Table(name = "electricity_billing_details")
@Data
@ToString
public class RegisterUserDetail {


	@Id
	@Column(name = "customer_id")
	public Long ConsumerId;

	@Column(name = "customer_name")
	public String FullName;

}