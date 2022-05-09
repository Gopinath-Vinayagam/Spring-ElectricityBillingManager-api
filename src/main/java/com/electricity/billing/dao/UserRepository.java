package com.electricity.billing.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electricity.billing.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	UserDetails save(UserDetails user);

	@Transactional
	@Modifying
	@Query("update UserDetails u set u.password=:password where u.emailId=:emailId ")
	int changePassword(@Param("emailId") String emailId, @Param("password") String password)throws SQLException;

	List<UserDetails> findAll();
	
	List<UserDetails>findByFullName(String fullName);

	List<UserDetails> findByconsumerId(long consumerId);
	
	
	//List<UserDetails> findByemailId(String emailId, String password);

	@Transactional
	@Modifying
	@Query("delete from UserDetails u where u.consumerId=:consumerId")
	int deleteByconsumerId(@Param("consumerId") long consumerId )throws SQLException;

	


	

	

	
	
}
