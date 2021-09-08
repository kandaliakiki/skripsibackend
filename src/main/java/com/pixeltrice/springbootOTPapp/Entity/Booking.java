package com.pixeltrice.springbootOTPapp.Entity;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.pixeltrice.springbootOTPapp.Generator.Generator;

@Entity
@Table(name = "booking_tbl")
public class Booking {


	
	@Id
	@Column(name = "booking_id", length = 15)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
	@GenericGenerator(name = "booking_seq", strategy = "com.pixeltrice.springbootOTPapp.Generator.Generator",
						parameters = {
								@Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
								@Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "BOOK_"),
	})
	private String booking_id;
	
	@Column(name = "booking_users_id",nullable = false, length = 15)
	private String bookingUsersId;


	@Column(name = "restaurant_id",nullable = false, length = 15)
	private String bookingRestaurantId;
	
	@Column(name = "booking_date", nullable = false, length = 15)
	private Date bookingDate;
	
	@Column(name = "booking_hour", nullable = false, length = 6)
	private Time booking_hour;
	

	@Column(name = "total_price", nullable = false, length = 10)
	private int totalPrice;
	
	@Column(name = "booking_status", nullable = false, length = 10)
	private String bookingStatus;
	
	@Column(name = "rating", nullable = true, length = 1)
	private int rating;
	
	@Column(name = "seat_no_booking", nullable = false, length = 20)
	private int seatNoBooking;
	
	@Column(name = "restoname", nullable = false, length = 50)
	private String restoname;
	
	
	
	public String getRestoname() {
		return restoname;
	}

	public void setRestoname(String restoname) {
		this.restoname = restoname;
	}

	public Time getBooking_hour() {
		return booking_hour;
	}

	public void setBooking_hour(Time booking_hour) {
		this.booking_hour = booking_hour;
	}


	
	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public String getBookingUsersId() {
		return bookingUsersId;
	}

	public void setBookingUsersId(String bookingUsersId) {
		this.bookingUsersId = bookingUsersId;
	}

	public String getBookingRestaurantId() {
		return bookingRestaurantId;
	}

	public void setBookingRestaurantId(String bookingRestaurantId) {
		this.bookingRestaurantId = bookingRestaurantId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getSeatNoBooking() {
		return seatNoBooking;
	}

	public void setSeatNoBooking(int seatNoBooking) {
		this.seatNoBooking = seatNoBooking;
	}
}
