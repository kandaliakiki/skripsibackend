package com.pixeltrice.springbootOTPapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pixeltrice.springbootOTPapp.Entity.Booking;
import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Entity.Sms;
import com.pixeltrice.springbootOTPapp.Entity.Users;

@Repository
public interface SmsRepository extends JpaRepository<Sms, Integer> {

	@Query(value = "SELECT count(*) FROM sms_tbl WHERE phone_no=:phoneno", nativeQuery = true)
	int checkavailableotp(String phoneno);

	@Query(value = "SELECT * FROM sms_tbl WHERE phone_no=:phoneno", nativeQuery = true)
	Sms getsmsbyphoneno(String phoneno);

	@Query(value = "SELECT otp_sms FROM sms_tbl WHERE phone_no=:phoneno", nativeQuery = true)
	String getotpforphone(String phoneno);
	
}
