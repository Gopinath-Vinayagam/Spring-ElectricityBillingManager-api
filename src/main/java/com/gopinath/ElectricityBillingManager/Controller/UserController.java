package com.gopinath.ElectricityBillingManager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopinath.ElectricityBillingManager.DAO.RegisterRepository;
import com.gopinath.ElectricityBillingManager.DAO.UserRepository;
import com.gopinath.ElectricityBillingManager.model.RegisterUserDetail;
import com.gopinath.ElectricityBillingManager.model.UserDetails;






@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RegisterRepository UserRepository;
	
	@GetMapping("User/registerUser")
	public String registerUser(@RequestParam("FullName")String FullName,@RequestParam("EmailId")String EmailId,@RequestParam("Password")String Password,
			@RequestParam("MobileNumber")String MobileNumber, @RequestParam("ConsumerType")String ConsumerType, @RequestParam("Address")String Address,@RequestParam("ConsumerId")String ConsumerId,@RequestParam("DateOfBirth")String DateOfBirth)
	{
		long Consumerid=Long.parseLong(ConsumerId);
		String UserName=FullName;
		RegisterUserDetail User=new RegisterUserDetail();
		User.setConsumerId(Consumerid);
		User.setFullName(FullName);
		UserDetails user = new UserDetails();
		user.setFullName(FullName);
		user.setEmailId(EmailId);
		user.setUserName(UserName);
		user.setPassword(Password);
		user.setMobileNumber(MobileNumber);
		user.setConsumerType(ConsumerType);
		user.setAddress(Address);
		user.setConsumerId(Consumerid);
		user.setDateOfBirth(DateOfBirth);
		UserDetails userObj = userRepository.save(user);
		RegisterUserDetail UserObj=UserRepository.save(User);
		
		
		return "Registered Successful & Registered as" +EmailId;
		
	}
	
	
	
	
	
	
	
	

}

