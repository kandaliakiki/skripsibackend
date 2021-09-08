package com.pixeltrice.springbootOTPapp.Service;

import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeltrice.springbootOTPapp.Entity.Booking;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Repository.BookingRepository;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;
import com.pixeltrice.springbootOTPapp.Repository.Restaurantrepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private RestaurantService restoservice;

		public List<String> checkavailableseat(String bookhour, String bookdate, String restaurantId) throws ParseException {
			String bookhourfordb = bookhour.split("-")[0].replaceAll("\\s+","");
			List<String> availableseatfinal = new ArrayList<String>();
			availableseatfinal=repository.getbookingsfromdb( bookhourfordb,  bookdate,  restaurantId);
					
			// TODO Auto-generated method stub
			return availableseatfinal;
		}



		public String addbooking(String restoid, String datedb, String bookhour, String users_id, int price,int seat) throws ParseException {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Instant instant = dateFormat.parse("2021/08/11").toInstant();
			ZoneId zoneId = ZoneId.of ( "Asia/Jakarta" );
			ZonedDateTime zdt = ZonedDateTime.ofInstant ( instant , zoneId );
			LocalDate localDate = zdt.toLocalDate();
			
			DateFormat hourformat = new SimpleDateFormat("hh:mm:ss");
			String bookhourfordb = bookhour.split("-")[0].replaceAll("\\s+","");
			java.sql.Time timeValue = new java.sql.Time(hourformat.parse(bookhourfordb).getTime());
//			Date bookingdate = dateFormat.parse(datedb) ;
			Booking bookingobj = new Booking();
			bookingobj.setBookingRestaurantId(restoid);
			bookingobj.setBookingDate(java.sql.Date.valueOf(localDate));
			bookingobj.setBooking_hour(timeValue);
			bookingobj.setBookingUsersId(users_id);
			bookingobj.setTotalPrice(price);
			bookingobj.setBookingStatus("ISSUED");
			bookingobj.setSeatNoBooking(seat);
			bookingobj.setRestoname(restoservice.getrestaurantbyid(restoid).getRestaurantName());
			repository.save(bookingobj);
			
			// TODO Auto-generated method stub
			return "Add Booking Berhasil !";
		}



		public List<Booking> getupcomingorders(String users_id) {
			
			List<Booking> upcomingorders = repository.getupcomingorders(users_id);
			
			// TODO Auto-generated method stub
			return upcomingorders;
		}



		public List<Booking> gethistoryorders(String users_id) {
			// TODO Auto-generated method stub
			
			List<Booking> historyorders = repository.gethistoryorders(users_id);
			return historyorders;
		}


	
		
		
}
