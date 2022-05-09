package com.electricity.billing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "admin_details")
@Data
@ToString
public class AdminDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AutoIncrement
	private Integer id;
	
	@Column(name = "name")
	public String adminName;
	
	@Column(name ="admin_id")
	public String adminId;
	
	@Column(name = "email")
	public String adminMailid;

	@Column(name = "pass")
	public String adminPassword;
	
	
	

}
