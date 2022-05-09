package com.electricity.billing.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.electricity.billing.model.AdminDetail;
import com.electricity.billing.model.RegisterUserDetail;
import com.electricity.billing.model.UserDetails;

@Repository
public interface AdminRepository extends JpaRepository<AdminDetail, Integer> {
	
	
	AdminDetail save(AdminDetail admin);

	@Modifying
	@Query("delete from AdminDetail u where u.id=:id")
	void deleteById(@Param("id") Integer id);

	@Transactional
	@Modifying
	@Query("update RegisterUserDetail u set u.units=:units,u.billAmount=:billpay,u.finalizedTotal=:billpay where u.consumerId=:consumerId ")
	 int billEntry(@Param("units") Integer units, @Param("billpay")  Double billpayDouble, @Param("consumerId") long consumerId)throws SQLException;

		


	

}
