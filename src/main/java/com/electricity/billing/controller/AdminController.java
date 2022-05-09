package com.electricity.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.electricity.billing.dao.AdminRepository;
import com.electricity.billing.dao.RegisterRepository;
import com.electricity.billing.dto.MessageDTO;
import com.electricity.billing.model.AdminDetail;
import com.electricity.billing.model.RegisterUserDetail;
import com.electricity.billing.model.UserDetails;
import com.electricity.billing.service.BillCalculationService;

@RestController
@RequestMapping("Admin")
public class AdminController {
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	RegisterRepository UserRepository;

	@Autowired
	BillCalculationService CalculationService;
	
	@PostMapping("register")
	public AdminDetail Adminregistration(@RequestBody AdminDetail admin){
		AdminDetail userObj = adminRepository.save(admin);
		return userObj;
   }




	@GetMapping("delete/{id}")
		public void delete(@PathVariable("id") Integer id) {
			adminRepository.deleteById(id);		 
		}
	
//	@PostMapping("BillEntry")
//	public String BillCalculator(@RequestBody RegisterUserDetail cal) {
//		
//		System.out.println(cal);
//		return CalculationService.calculate(cal);
//		// CalculationService.calculate(cal);
//	}
		
		
		@PostMapping("BillEntry")
		public MessageDTO BillCalculator(@RequestBody RegisterUserDetail cal) {
			
			System.out.println(cal);
			String result = CalculationService.calculate(cal);
			System.out.println(result);
			return new MessageDTO(result);
			// CalculationService.calculate(cal);
			
	}
	
	
	
	
	

}
	
