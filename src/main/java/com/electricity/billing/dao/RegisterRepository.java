package com.electricity.billing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.electricity.billing.model.RegisterUserDetail;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterUserDetail, Integer> {
	
	
	RegisterUserDetail save(RegisterUserDetail User);
	
	
	/*@Transactional
	@Modifying
	@Query("update User u set u.PASSWORD = :Password where u.customer_id=:ConsumerId")
	void changePassword(@Param("ConsumerId") Integer ConsumerId, @Param("Password") String Password);*/
}