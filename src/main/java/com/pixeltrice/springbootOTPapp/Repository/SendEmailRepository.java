package com.pixeltrice.springbootOTPapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pixeltrice.springbootOTPapp.Entity.Booking;
import com.pixeltrice.springbootOTPapp.Entity.EmailVerif;
import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Entity.Sms;

@Repository
public interface SendEmailRepository extends JpaRepository<EmailVerif, Integer> {

	
	@Query(value = "SELECT count(*) FROM emailverif_tbl WHERE email=:email", nativeQuery = true)
	int checkavailableemail(String email);
	
	@Query(value = "SELECT * FROM emailverif_tbl WHERE email=:email", nativeQuery = true)
	EmailVerif getentitybyemail(String email);

	@Query(value = "SELECT verif_code FROM  emailverif_tbl WHERE email=:email", nativeQuery = true)
	String getotpemail(String email);



	
}
