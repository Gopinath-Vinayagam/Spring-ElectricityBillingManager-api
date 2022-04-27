package com.gopinath.ElectricityBillingManager.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gopinath.ElectricityBillingManager.model.RegisterUserDetail;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterUserDetail, Integer> {
	
	
	RegisterUserDetail save(RegisterUserDetail User);
	
	/*@Transactional
	@Modifying
	@Query("update User u set u.PASSWORD = :Password where u.customer_id=:ConsumerId")
	void changePassword(@Param("ConsumerId") Integer ConsumerId, @Param("Password") String Password);*/
}