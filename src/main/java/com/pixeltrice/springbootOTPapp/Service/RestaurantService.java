package com.pixeltrice.springbootOTPapp.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;
import com.pixeltrice.springbootOTPapp.Repository.Restaurantrepository;

@Service
public class RestaurantService {
	
	@Autowired
	private Restaurantrepository repository;
	
	public Restaurant getrestaurantbyid (String id ) 
	{
		System.out.println("masuk sini");
		return repository.findByrestaurantId(id).orElse(null);
	}
	
	
	public List<Restaurant> getrestaurantsrandom(String count)
	{
		List<String> restaurantids = repository.getrestaurantrandomorder(Integer.parseInt(count));
		List<Restaurant> restaurantsfinal = new ArrayList<>();
		for(int i = 0 ; i < restaurantids.size();i++) 
		{
			restaurantsfinal.add(getrestaurantbyid(restaurantids.get(i).toString()));
		}
		return restaurantsfinal;
	}
	
	public List<Restaurant> getallresto(String count)
	{
		List<Restaurant> restaurantsfinal = new ArrayList<>();
		if(Integer.parseInt(count)>0) 
		{
			
			List<String> restaurantids = repository.getrestaurantbyorder(Integer.parseInt(count));
			
			for(int i = 0 ; i < restaurantids.size();i++) 
			{
				restaurantsfinal.add(getrestaurantbyid(restaurantids.get(i).toString()));
			}
		}else 
		{
			restaurantsfinal=repository.findAll();
		}
		return restaurantsfinal;
	}

	
	public List<Restaurant> getrestaurantsbydistance(String latitude , String longitude, int count)
	{
		List<String> restaurantids = repository.getrestaurantbyorder(count);
		List<Restaurant> restaurantsobj = new ArrayList<>();
		HashMap <Double, Restaurant> mapresto = new HashMap<Double, Restaurant>();
		HashMap <String, Double> maprestowithid = new HashMap<String, Double>();
		List<Double> distances= new ArrayList<>();
		List<Restaurant> restaurantfinal = new ArrayList<>();
		for(int i = 0 ; i < restaurantids.size();i++) 
		{
			Restaurant restoobj =getrestaurantbyid(restaurantids.get(i).toString());  
			restaurantsobj.add(restoobj);
			double distancediff = distance(Double.parseDouble(latitude), Double.parseDouble(longitude),
					Double.parseDouble(restoobj.getLatitude()), Double.parseDouble(restoobj.getLatitude()), 'K');
			distances.add(distancediff); //masukin ke list distance
			maprestowithid.put(restaurantids.get(i).toString(),distancediff); //masukin id dan difference
			
		} 
			
	
		Collections.sort(distances); //urutin 
		for(int i = 0 ; i < distances.size();i++) //panggil dari hashmap sesuai urutan distance 
		{
			for(int j= 0 ; j<restaurantsobj.size();j++) 
			{
				if(maprestowithid.get(restaurantsobj.get(j).getRestaurantId()).compareTo(distances.get(i))==0 ) 
				{
					if(!restaurantfinal.contains(restaurantsobj.get(j))) 
					{
						
						restaurantfinal.add(restaurantsobj.get(j));
						restaurantsobj.remove(j);
						break; 
					}
				}
			}
		}
		
		
		return restaurantfinal;
	}

	public List<String> getimagedetailresto(String restaurantid,int count)
	{
		List<String> images = new ArrayList<>(); 
		if(count>0)
		{
			images = repository.getallimgrestowihtlimit(restaurantid,count);
		}else 
		{
			images = repository.getallimgresto(restaurantid);
		}
	
		return images;
	}
	
	public String getpaymentsrc(String payment_src) {
		
		String paymentsrc_id[] = payment_src.split(",");
		String paymentsrc_akhir="";
		for(int i = 0 ; i< paymentsrc_id.length;i++) 
		{
			String prefix = "PAYSRC_";
			String paymentname = repository.getpaymentnamefromdb(prefix+paymentsrc_id[i]);
			if(paymentsrc_akhir.isBlank()) 
			{
				paymentsrc_akhir=paymentname;
			}else 
			{
				paymentsrc_akhir=paymentsrc_akhir+" , "+paymentname;
			}
		}
		return paymentsrc_akhir;
	}
	
	
	
	private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
		  double theta = lon1 - lon2;
		  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;
		  if (unit == 'K') {
		    dist = dist * 1.609344;
		  } else if (unit == 'N') {
		  dist = dist * 0.8684;
		    }
		  return (dist);
		}

		
		private double deg2rad(double deg) {
		  return (deg * Math.PI / 180.0);
		}

		private double rad2deg(double rad) {
		  return (rad * 180.0 / Math.PI);
		}


		public List<Restaurant> searchrestaurant(String restoname) {
			String[] restonamesplitted = restoname.trim().split(" ");
			List<Restaurant> hasilsearchakhir = new ArrayList<Restaurant>();
			for(int i = 0 ; i < restonamesplitted.length;i++) 
			{
				List<Restaurant> hasilsearch = repository.searchresto(restonamesplitted[i]);
				for(int j = 0 ; j < hasilsearch.size();j++) 
				{
					if(!hasilsearchakhir.contains(hasilsearch.get(j))) 
					{
						hasilsearchakhir.add(hasilsearch.get(j));
					}
				}
			}
			// TODO Auto-generated method stub
			return hasilsearchakhir;
		}


		  public  String getrestaurantcrowd(String date, String hour) throws JsonProcessingException, JSONException {
			// TODO Auto-generated method stub
			  List<Restaurant> restos = getallresto("0");
			  Instant currentdate = Instant.now();
//			  currentdate.get(0);
			  if(date.toUpperCase().contains("CHOOSE")) 
			  {
				  
				  date = currentdate.toString().substring(0,10).replace("-", "/");
			  }
			  List<JSONObject> hasiljson = new ArrayList<JSONObject>();
			  for(int i = 0 ; i < restos.size();i++) 
			  {
				  ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				  String json = ow.writeValueAsString(restos.get(i));
				  JSONObject  restojson = new JSONObject(json);
				  String countbook = repository.getcountbook(date,hour,restos.get(i).getRestaurantId().toUpperCase());
				  BigDecimal countseat = new BigDecimal(restos.get(i).getSeat_count());
				  BigDecimal percentbooked = new BigDecimal(countbook).divide(countseat,2,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
				  String percentbookedtext = percentbooked.toString().contains(".")
						  ? percentbooked.toString().replaceAll("0*$","").replaceAll("\\.$","") 
						  : percentbooked.toString();
				  restojson.put("booked", countbook);
				  restojson.put("percentbooked", percentbookedtext+ " %");
				  hasiljson.add(restojson);
			  }
		
			return hasiljson.toString();
		}


		public String getrestaurantcrowdsearch(String date, String hour, String search) throws JsonProcessingException, JSONException {
			// TODO Auto-generated method stub
			  List<Restaurant> restos = searchrestaurant(search);
			  Instant currentdate = Instant.now();
//			  currentdate.get(0);
			  if(date.toUpperCase().contains("CHOOSE")) 
			  {
				  
				  date = currentdate.toString().substring(0,10).replace("-", "/");
			  }
			  List<JSONObject> hasiljson = new ArrayList<JSONObject>();
			  for(int i = 0 ; i < restos.size();i++) 
			  {
				  ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				  String json = ow.writeValueAsString(restos.get(i));
				  JSONObject  restojson = new JSONObject(json);
				  String countbook = repository.getcountbook(date,hour,restos.get(i).getRestaurantId().toUpperCase());
				  BigDecimal countseat = new BigDecimal(restos.get(i).getSeat_count());
				  BigDecimal percentbooked = new BigDecimal(countbook).divide(countseat,2,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
				  String percentbookedtext = percentbooked.toString().contains(".")
						  ? percentbooked.toString().replaceAll("0*$","").replaceAll("\\.$","") 
						  : percentbooked.toString();
				  restojson.put("booked", countbook);
				  restojson.put("percentbooked", percentbookedtext+ " %");
				  hasiljson.add(restojson);
			  }
		
			return hasiljson.toString();
		}


	
		
		
}
