package com.gopinath.ElectricityBillingManager.DAO;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.gopinath.ElectricityBillingManager.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {
	
	UserDetails save(UserDetails user);
	
	
	/*@Transactional
	@Modifying
	@Query("update User u set u.PASSWORD = :Password where u.customer_id=:ConsumerId")
	void changePassword(@Param("ConsumerId") Integer ConsumerId, @Param("Password") String Password);*/
}


