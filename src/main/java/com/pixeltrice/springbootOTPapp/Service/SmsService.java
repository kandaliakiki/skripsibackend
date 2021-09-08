package com.pixeltrice.springbootOTPapp.Service;

import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Entity.Sms;
import com.pixeltrice.springbootOTPapp.Repository.BookingRepository;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;
import com.pixeltrice.springbootOTPapp.Repository.Restaurantrepository;
import com.pixeltrice.springbootOTPapp.Repository.SmsRepository;
import com.twilio.Twilio;
//import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class SmsService {
	
	@Autowired
	private SmsRepository repository;
	
	 public final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	 public final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
	 public final String FROM_NUMBER = "+14802073637";

		public String sendotp(String phonenotujuan) {
			// TODO Auto-generated method stub
			
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			int min = 100000;
			int max = 999999;
			String phonenotujuanforsms = phonenotujuan;
			int number = (int) (Math.random()*(max-min+1)+min);
			String otp = Integer.toString(number);
			if(phonenotujuanforsms.substring(0,1).equalsIgnoreCase("0")) 
			{
				phonenotujuanforsms="+62"+phonenotujuanforsms.substring(1,phonenotujuanforsms.length());
				System.out.println("phonenotujuan sekarang : "+phonenotujuanforsms);
			}
			String msg = "Your OTP - " + otp + " verify this OTP in your Application";
//			Message message = Message.creator(new PhoneNumber(phonenotujuanforsms), new PhoneNumber(FROM_NUMBER), msg).create();
//			 System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

			if(repository.checkavailableotp(phonenotujuan)>0) 
			{
				Sms smstemp = repository.getsmsbyphoneno(phonenotujuan);
				smstemp.setOtp_sms(otp); 
				repository.save(smstemp);
			}else {
			 
				Sms smstemp = new Sms();
				smstemp.setOtp_sms(otp); 
				smstemp.setPhone_no(phonenotujuan);
				
				repository.save(smstemp);
				}
			return "SMS Sudah Terkirim!";
		}

		public String verifyotp(String phoneno, String otp) {
			String getotpforphoneno = repository.getotpforphone(phoneno);
			if(getotpforphoneno!=null && otp.equalsIgnoreCase(getotpforphoneno)) 
			{
				Sms smstemp = repository.getsmsbyphoneno(phoneno);
				repository.delete(smstemp);
				return "Verifikasi OTP Berhasil";
			}else 
			{
				return "Verifikasi OTP gagal!";
			}
			
		}


	
		
		
}
