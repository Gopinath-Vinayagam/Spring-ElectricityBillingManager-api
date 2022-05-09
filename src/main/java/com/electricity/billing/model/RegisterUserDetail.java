package com.electricity.billing.model;

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
	public Long consumerId;

	@Column(name = "customer_name")
	public String fullName;
	
	@Column(name = "consumer_Type")
	public String consumerType;
	
	@Column(name = "unit_consumed")
	public Integer units;
	
	@Column(name = "bill_due_date")
	public String dueDate;
	
	@Column(name = "bill_amount")
	public Double billAmount;
	
	@Column(name = "penalty")
	public String penalty;
	
	@Column(name = "billing_status")
	public String billingStatus;
	
	@Column(name = "finalized_total")
	public Double finalizedTotal;
	

}