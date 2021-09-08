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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.pixeltrice.springbootOTPapp.Entity.EmailVerif;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Entity.Sms;
import com.pixeltrice.springbootOTPapp.Entity.Users;
import com.pixeltrice.springbootOTPapp.Repository.BookingRepository;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;
import com.pixeltrice.springbootOTPapp.Repository.Restaurantrepository;
import com.pixeltrice.springbootOTPapp.Repository.SendEmailRepository;
import com.pixeltrice.springbootOTPapp.Repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.pixeltrice.springbootOTPapp.Entity.EmailVerif;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SendEmailService {
	
	@Autowired
	private SendEmailRepository repository;
	
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
    private UserService userservice;
	
	public String sendEmail( String email) {
    	int min = 100000;
		int max = 999999;
		
		int number = (int) (Math.random()*(max-min+1)+min);
		String otp = Integer.toString(number);
   
		Users usercek = userservice.cekuserbyemail(email);
		if(usercek!=null) 
		{
			return "Failed";
		}else 
		{
			
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(email);
			
			msg.setSubject("Verify Your OTP");
			msg.setText("Your OTP - " + otp + ". Verify this OTP in your Application");
			
			javaMailSender.send(msg);
			
			if(repository.checkavailableemail(email)>0) 
			{
				EmailVerif emailtemp = repository.getentitybyemail(email);
				emailtemp.setVerif_code(otp); 
				repository.save(emailtemp);
			}else 
			{
				
				EmailVerif emailtemp = new EmailVerif();
				emailtemp.setVerif_code(otp); 
				emailtemp.setUsers_email(email);; 
				repository.save(emailtemp);
			}
			
			return "Success";
		}
    }

	public String verifyotpemail(String email, String verifcode) {
		// TODO Auto-generated method stub
		String getotpemail = repository.getotpemail(email);
		if(getotpemail!=null && verifcode.equalsIgnoreCase(getotpemail)) 
		{
			EmailVerif emailtemp = repository.getentitybyemail(email);
			repository.delete(emailtemp);
			return "Verifikasi OTP email Berhasil";
		}else 
		{
			return "Verifikasi OTP email gagal!";
		}
	}




	
		
		
}
