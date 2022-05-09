package com.electricity.billing.service;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import com.electricity.billing.dao.AdminRepository;
import com.electricity.billing.model.AdminDetail;
import com.electricity.billing.model.RegisterUserDetail;

@Slf4j
@Configuration
public class BillCalculationService {

	@Autowired
	AdminRepository billentry;

	public String calculate(RegisterUserDetail cal) {
		System.out.println(cal);
		String res = null;
		int units = cal.getUnits();
		String type = cal.getConsumerType();

		long consumerId = cal.getConsumerId();
		double billpay = 0;
		if ("Domestic".equals(type)) {

			if (units <= 100) {
				billpay = units * 0;
			} else if (units > 100 && units <= 200) {
				billpay = (units - 100) * 1.5 + 20;
			} else if (units > 200 && units <= 500) {
				billpay = (units - 100) * 3 + 30;
			} else if (units > 500) {
				billpay = (units - 100) * 4.5 + 50;
			}
			try {
				int n = billentry.billEntry(units, billpay, consumerId);
				System.out.println(n);
				if (n==1) {
				res = "success";}
				else {
				 
					res = "unsuccess";
				
				}
				
			} catch (SQLException e) {
				res = "unsuccess";
			}
		}

		else {

			billpay = units * 7.35;

			try {
				int n = billentry.billEntry(units, billpay, consumerId);
				if (n==1) {
				res = "success";}
				else {
					 
					res = "unsuccess";
				
				}
				
				
			} catch (SQLException e) {
				res = "unsuccess";
			}

		}

		return res;
	}
}
//
