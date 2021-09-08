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
import com.pixeltrice.springbootOTPapp.Entity.Users;
import com.pixeltrice.springbootOTPapp.Repository.BookingRepository;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;
import com.pixeltrice.springbootOTPapp.Repository.Restaurantrepository;
import com.pixeltrice.springbootOTPapp.Repository.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository repository;
	


//	public Users getuserbyemail (String email) 
//	{
//		System.out.println("masuk sini");
//		return repository.findByusers_id(email).orElse(null);
//	}
	
	public Users cekuserbyemail(String email){
		
		Users cekuser =  repository.getuseridbyemail(email);
		if(cekuser==null) 
		{
			return null;
		}else 
		{
			return cekuser;
		}

	}



	public String loginbyemail(String email, String password) {
		
		Users loginuserid = repository.userloginbyemail(email,password);
		if(loginuserid==null) 
		{
			return "Login Gagal";
		}else 
		{
			return "Login Berhasil";
		}
		
		// TODO Auto-generated method stub
		
	}
	

	public String loginbyphone(String phoneno) {
		
		Users loginuserid = repository.userloginbyphone(phoneno);
		if(loginuserid==null) 
		{
			return "Login Gagal";
		}else 
		{
			return "Login Berhasil";
		}
		
		// TODO Auto-generated method stub
		
	}



	public Users getuserbyemail(String email) {
		// TODO Auto-generated method stub
		Users cekuser =  repository.getuseridbyemail(email);
		return cekuser;
	}

	public Users getuserbyphoneno(String phoneno) {
		// TODO Auto-generated method stub
		Users cekuser =  repository.getuseridbyphoneno(phoneno);
		return cekuser;
	}



	public Users registeruser(String email, String phoneno, String fullname, String password) {
		
		Users regisuser = new Users();
		regisuser.setUsers_email(email);
		regisuser.setUsers_phone(phoneno);
		regisuser.setUsers_name(fullname);
		regisuser.setUsers_password(password);
		repository.save(regisuser);
		// TODO Auto-generated method stub
		return regisuser;
	}

	
		
		
}
