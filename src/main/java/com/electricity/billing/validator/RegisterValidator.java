package com.electricity.billing.validator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.electricity.billing.Exception.ValidatorException;
import com.electricity.billing.model.UserDetails;
import com.electricity.billing.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration

public class RegisterValidator {

//	public String loginValidation(List<UserDetails> m, UserDetails user) {
//
//		String ans = null;
//		for (UserDetails u : m) {
//			if(u.getEmailId().equals( user.getEmailId()) && u.getPassword().equals(user.getPassword())) {
//				log.info("this email id and password is  presnt");
//				ans = "success";
//				break;
//			}
//			else {
//				ans = "unsuccess";
//			}
//		}
//		return ans;
//	}
//
//	public String emailPasswordValidation(List<UserDetails> m, UserDetails user) {
//		
//		return    ;
//	}
//	

	//@Configuration
	
	//u.getUserMailId().equals( user.getUserMailId()) || u.getUserPass().equals(user.getUserPass())
	    public String emailPasswordValidation(List<UserDetails> m, UserDetails user) {
	        String ans = null;
	        for (UserDetails u : m) {
//	        	System.out.println(u.getEmailId() + user.getEmailId());
//	        	System.out.println(u.getEmailId() .equals( user.getEmailId()));
	            if(u.getEmailId() .equals(user.getEmailId())) {
	                
	                ans = "success";
	                break;
	            }
	            else {
	            	log.info("email id not present");
	                ans = "invalid credential";
	            }
	        }
	        return ans;
	    }
	    public void loginFieldValidation(UserDetails user) throws Exception {
	        long consumerid=user.getConsumerId();
	    	String userMailId = user.getEmailId();
	         String userPass = user.getPassword();
	         String userName = user.getFullName();
	         LocalDate dateOfBirth = user.getDateOfBirth();
	         String consumerType = user.getConsumerType();        
	       
	         String address = user.getAddress();
	      
	         String phoneNumber = user.getMobileNumber();
//	             try {    
	            fieldMailIdValidation(userMailId);
	            fieldPasswordValidation(userPass);
	            fieldDateOfBirthValidate(dateOfBirth);
//	             }catch() {
//	             }
	            if(userName == null || "".equals(userMailId.trim())) {
	                throw new ValidatorException("name filed is not empty");    
	            }
	            if(consumerType ==  null || "".equals(consumerType.trim())) {
	                throw new ValidatorException("data filed is not empty");    
	            }
	            
	            if(address == null || "".equals(address.trim())) {
	                throw new ValidatorException("address filed is not empty");
	            }
	            
	            if(phoneNumber == null) {
	                throw new ValidatorException("phone number filed is not empty");
	            }
	    }
	    public void fieldDateOfBirthValidate(LocalDate dateOfBirth) throws ValidatorException {
	        if(dateOfBirth == null) {
	            throw new ValidatorException("date of birth filed is mandatory");
	        }
	        if(dateOfBirth.isBefore(LocalDate.now())) {
	            throw new ValidatorException("feature date is not date of birth");
	        }
	    }
	    public void fieldMailIdValidation(String userMailId) throws ValidatorException {
	        String inValid = "invalid email Id";
	        if(userMailId == null || "".equals(userMailId.trim())) {
	            throw new ValidatorException(inValid);
	        }
	        if(!userMailId.contains("@")){
	            throw new ValidatorException(inValid);
	        }
	    }
	    public void fieldPasswordValidation(String userPass) throws ValidatorException {
	        String inValid = "password field cannot is empty";
	        if(userPass == null || "".equals(userPass.trim())) {
	            throw new ValidatorException(inValid);
	        }        
	    }
	    public String loginValidation(List<UserDetails> m, UserDetails user) {
	        String ans = null;
	        for (UserDetails u : m) {
	            if(u.getEmailId().equals( user.getEmailId()) && u.getPassword().equals(user.getPassword())) {
	                log.info("this email id and password is  presnt");
	                ans = "success";
	                break;
	            }
	            else {
	                ans = "unsuccess";
	            }
	        }
	        return ans;
	    }
	}

	
	


	
	
	
	
	
	


