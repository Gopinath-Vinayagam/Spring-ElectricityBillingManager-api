package com.electricity.billing.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.electricity.billing.Exception.ValidatorException;
import com.electricity.billing.dao.UserRepository;
import com.electricity.billing.model.UserDetails;
import com.electricity.billing.validator.RegisterValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RegisterValidator validation;

	public String insertUserDetails(UserDetails user) {
		String ans = null;
		try {
			UserDetails m = userRepository.save(user);
			if (m != null) {
				ans = "success";
			} else {
				throw new ValidatorException("unsuccess");
			}
		} catch (Exception e) {
			ans = "unsuccess";
		}

		return ans;
	}

	public Object getEmailAndPass(UserDetails user) {

		String ans = null;
		try {
			List<UserDetails> m = userRepository.findAll();
			if (m != null) {
				ans = validation.emailPasswordValidation(m, user);
			} else {
				throw new SQLException("records not found");
			}
		} catch (RuntimeException e) {
			log.info("email id and password verfication is unsuccess");
			ans = "unsuccess";
		} catch (SQLException e) {
			log.warn("records not found");
			ans = e.getMessage();
		}
		return ans;
	}

	
	
	
	//login

	public Object Login(UserDetails user) {
		String ans = null;
		
		try {
			List<UserDetails> m = userRepository.findAll();
			if (m != null) {
				ans = validation.emailPasswordValidation(m, user);
			} else {
				throw new SQLException("records not found");
			}
		} catch (RuntimeException e) {
			log.info("email id and password verfication is unsuccess");
			ans = "unsuccess";
		} catch (SQLException e) {
			log.warn("records not found");
			ans = e.getMessage();
		}
		return ans;
	}

	
	//Forgot password
	
	public Object forgotPassword( String emailId,String password) throws Exception {

		String result = null;
		try {
			int m = userRepository.changePassword(emailId, password);
			if (m != 0) {
				result = "successfull";

			} else {
				result = "unsuccessfull";
			}
		} catch (SQLException e) {
			result = "unsuccessfull";
		}
		return result;
	}
	
	// DELETE BY ID
	
	public Object deleteByconsumerId(long consumerId) {

		log.info("consumer id :" + " " + consumerId);
		String ans = null;
		try {
			int n = userRepository.deleteByconsumerId(consumerId);
			log.info("deleted consumer id :" + " " + consumerId);
			ans = "your account has been removed ";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		log.warn("consumeId :" + " " + consumerId + " " + "is user id not removed");
			ans = "sorry your account is not remove";
		}
		return ans;
	}

	// public List<Application> getApplicationByUserMailId(String emailId) {
	// return application.findApplicationByEmail(emailId);
	// }

}
