package com.pixeltrice.springbootOTPapp.Controller;

import java.sql.SQLException;
import java.text.ParseException;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Repository.BookingRepository;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;
import com.pixeltrice.springbootOTPapp.Repository.Restaurantrepository;
import com.pixeltrice.springbootOTPapp.Repository.SmsRepository;
import com.pixeltrice.springbootOTPapp.Service.BookingService;
import com.pixeltrice.springbootOTPapp.Service.ImageService;
import com.pixeltrice.springbootOTPapp.Service.RestaurantService;
import com.pixeltrice.springbootOTPapp.Service.SmsService;


@RestController
public class SmsController {
	
	@Autowired
	private SmsRepository repository;

	
	@Autowired
	private SmsService smsservice;

    

    
    @PostMapping("/sendotp")
    public String sendotp(@RequestBody String parameter ) throws JSONException, ParseException{

    	JSONObject params = new JSONObject(parameter);
		return smsservice.sendotp(params.getString("phoneno"));
    	
    }
    
    @PostMapping("/verifyotp")
    public String verifyotp(@RequestBody String parameter ) throws JSONException, ParseException{

    	JSONObject params = new JSONObject(parameter);
		return smsservice.verifyotp(params.getString("phoneno"),params.getString("otp"));
    	
    }
    
	

    

}
