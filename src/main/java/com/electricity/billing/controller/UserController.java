package com.electricity.billing.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electricity.billing.dao.RegisterRepository;
import com.electricity.billing.dao.UserRepository;

import com.electricity.billing.model.RegisterUserDetail;
import com.electricity.billing.model.UserDetails;
import com.electricity.billing.service.UserService;

@RestController
@RequestMapping("User")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	RegisterRepository UserRepository;
	@Autowired
	UserService service;

	@GetMapping("register")
	public Object registerUser(@RequestParam("FullName") String fullName, @RequestParam("EmailId") String emailId,
			@RequestParam("Password") String password, @RequestParam("MobileNumber") String mobileNumber,
			@RequestParam("ConsumerType") String consumerType, @RequestParam("Address") String address,
			@RequestParam("ConsumerId") long consumerId, @RequestParam("DateOfBirth") String dateOfBirth) {
		//long consumerid = Long.parseLong(ConsumerId);
		LocalDate dob = LocalDate.parse(dateOfBirth);
		RegisterUserDetail User = new RegisterUserDetail();
		User.setConsumerId(consumerId);
		User.setFullName(fullName);
		UserDetails user = new UserDetails();
		user.setFullName(fullName);
		user.setEmailId(emailId);
		user.setPassword(password);
		user.setMobileNumber(mobileNumber);
		user.setConsumerType(consumerType);
		user.setAddress(address);
		user.setConsumerId(consumerId);
		user.setDateOfBirth(dob);
		UserDetails userObj = userRepository.save(user);

		RegisterUserDetail UserObj = UserRepository.save(User);

		return service.insertUserDetails(user);

	}
	
	
	
	@PostMapping("login")
	public Object Userlogin(@RequestBody UserDetails user) {
		System.out.println(user);
		return service.Login(user);
		

	}
	
	
	

	@GetMapping("ChangePassword")
	public void changePassword(@RequestParam("EmailId") String emailId, @RequestParam("Password") String password)
			throws Exception {

		service.forgotPassword(emailId, password);
	}
	
	
	

	@GetMapping("list")
	public List<UserDetails> getAllUsers() {
		List<UserDetails> userList = userRepository.findAll();
		return userList;

	}
	
	
	

	@GetMapping("findByFullName/{FullName}")
	public List<UserDetails> findByname(@PathVariable("FullName") String fullName) {
		List<UserDetails> userList = null;
		try {
			userList = userRepository.findByFullName(fullName);

		} catch (Exception e) {
			e.printStackTrace();
			// result="failed";
		}

		return userList;
	}

	
	
	

	@GetMapping("deleteUser")
	public Object delete(@RequestParam ("ConsumerId") long consumerId) {
		return service.deleteByconsumerId(consumerId);
	}

	

	
	
	@GetMapping("findByconsumerId/{ConsumerId}")
	public List<UserDetails> findByConsumerId(@PathVariable("ConsumerId") long consumerId) {
		List<UserDetails> userList = null;
		try {
			userList = userRepository.findByconsumerId(consumerId);

		} catch (Exception e) {
			e.printStackTrace();
			// result="failed";
		}

		return userList;
	}

//	@PostMapping("login")
//	public 

}
