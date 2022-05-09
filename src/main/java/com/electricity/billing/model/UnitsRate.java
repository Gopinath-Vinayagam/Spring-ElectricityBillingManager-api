package com.electricity.billing.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "admin_details")
@Data
@ToString
public class UnitsRate

{
	@Id

	@Column(name = "consumer_Type")
	public String consumerType;

	@Column(name = "twohundred")
	public String tariffOne;

	@Column(name = "fivehundred")
	public String tariffTwo;

	@Column(name = "thousand")
	public LocalDate tariffThree;
	
}
