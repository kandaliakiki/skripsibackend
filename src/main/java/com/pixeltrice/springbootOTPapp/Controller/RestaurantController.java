package com.pixeltrice.springbootOTPapp.Controller;

import java.sql.SQLException;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;
import com.pixeltrice.springbootOTPapp.Repository.Restaurantrepository;
import com.pixeltrice.springbootOTPapp.Service.ImageService;
import com.pixeltrice.springbootOTPapp.Service.RestaurantService;


@RestController
public class RestaurantController {
	
	@Autowired
	private Restaurantrepository repository;

	
	@Autowired
	private RestaurantService restoservice;

    
    @PostMapping("/getrestaurantimgrandom")
    public List<Restaurant> getListRestaurantImage(@RequestBody String count ) throws JSONException{

    	JSONObject tes = new JSONObject(count);
		return restoservice.getrestaurantsrandom(tes.getString("count"));
    	
    }
    
    @PostMapping("/getListRestaurantbyDistance")
    public List<Restaurant> getListRestaurantbyDistance(@RequestBody String parameter ) throws JSONException{

    	JSONObject params = new JSONObject(parameter);
		return restoservice.getrestaurantsbydistance(params.getString("latitude"),params.getString("longitude"),params.getInt("count"));
    	
    }
    
    @PostMapping("/getallresto")
    public List<Restaurant> getallrestaurant(@RequestBody String parameter ) throws JSONException{

    	JSONObject params = new JSONObject(parameter);
		return restoservice.getallresto(params.getString("count"));
    	
    }
    
    @PostMapping("/getdetailrestaturantimage")
    public List<String> getdetailrestaurantimg(@RequestBody String parameter ) throws JSONException{

    	JSONObject params = new JSONObject(parameter);
		return restoservice.getimagedetailresto(params.getString("restaurantId"),params.getInt("count"));
    	
    }
    
    @PostMapping("/getrestaurantbyid")
    public Restaurant getrestaurantbyid(@RequestBody String parameter ) throws JSONException{

    	JSONObject params = new JSONObject(parameter);
		return restoservice.getrestaurantbyid(params.getString("restaurantId"));
    	
    }
    
    @PostMapping("/getpaymentsourcename")
    public String getpaymentsourcename(@RequestBody String parameter ) throws JSONException{

    	JSONObject params = new JSONObject(parameter);
		return restoservice.getpaymentsrc(params.getString("payment_souce"));
    	
    }
    
    @PostMapping("/searchrestaurant")
    public List<Restaurant> searchrestaurant(@RequestBody String parameter ) throws JSONException{

    	JSONObject params = new JSONObject(parameter);
		return restoservice.searchrestaurant(params.getString("search"));
    	
    }
    
    @PostMapping("/getrestaurantcrowd")
    public String getrestaurantcrowd(@RequestBody String parameter ) throws JSONException, JsonProcessingException{

    	JSONObject params = new JSONObject(parameter);
//    	JSONObject hasiljson =
//    	JSONObject hasil = new JSONObject(restoservice.getrestaurantcrowd(params.getString("date"),params.getString("hour")));
		return restoservice.getrestaurantcrowd(params.getString("date"),params.getString("hour")) ;
    	
    }
    
    @PostMapping("/getrestaurantcrowdsearch")
    public String getrestaurantcrowdsearch(@RequestBody String parameter ) throws JSONException, JsonProcessingException{

    	JSONObject params = new JSONObject(parameter);
//    	JSONObject hasiljson =
//    	JSONObject hasil = new JSONObject(restoservice.getrestaurantcrowd(params.getString("date"),params.getString("hour")));
		return restoservice.getrestaurantcrowdsearch(params.getString("date"),params.getString("hour"),params.getString("search")) ;
    	
    }

}
