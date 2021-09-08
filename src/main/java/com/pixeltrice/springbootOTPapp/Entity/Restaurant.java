package com.pixeltrice.springbootOTPapp.Entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.catalina.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.pixeltrice.springbootOTPapp.Generator.Generator;


																						
@Entity
@Table(name = "Restaurant_tbl")
public class Restaurant {
	
	@Id
	@Column(name = "restaurant_id", length = 6)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
	@GenericGenerator(name = "restaurant_seq", strategy = "com.pixeltrice.springbootOTPapp.Generator.Generator",
						parameters = {
								@Parameter(name = Generator.INCREMENT_PARAM, value = "1"),
								@Parameter(name = Generator.VALUE_PREFIX_PARAMETER, value = "RE_"),
	})
	private String restaurantId;
	
	@OneToOne(optional = true)
	@JoinColumn(name = "user_id_fk")
	private Users usersFkId;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "promo_id_fk", referencedColumnName = "restaurant_id")
//	private Promo promoIdFk;
//	
//	public Promo getPromoIdFk() {
//		return promoIdFk;
//	}
//
//	public void setPromoIdFk(List<Promo> promoIdFk) {
//		this.promoIdFk = promoIdFk;
//	}

	@Column(name = "restaurant_name", nullable = false, length = 50)
	private String restaurantName;
	
	@Column(name = "restaurant_rating", nullable = false, length = 5)
	private int restaurantRating;
	
	@Column(name = "restaurant_address", nullable = false, length = 255)
	private String restaurantAddress;

	@Column(name = "restaurant_pictures", nullable = true, length = 50)
	private String restaurantPictures;
	
	@Column(name = "restaurant_desc", nullable = true, length = 50)
	private String restaurantDesc;
	
	@Column(name = "restaurant_kota", nullable = false, length = 15)
	private String restaurantKota;
	
	@Column(name = "restaurant_email", nullable = false, length = 20)
	private String restaurantEmail;
	
	@Column(name = "restaurant_phoneno", nullable = false, length = 20)
	private String restaurant_phoneno;
	
	public String getRestaurant_phoneno() {
		return restaurant_phoneno;
	}

	public void setRestaurant_phoneno(String restaurant_phoneno) {
		this.restaurant_phoneno = restaurant_phoneno;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	@Column(name = "cuisines_type", nullable = false, length = 15)
	private String cuisinesType;
	
	@Column(name = "cost_start", nullable = true, length = 10)
	private String costStart;
	
	@Column(name = "cost_end", nullable = true, length = 10)
	private String costEnd;
	
	@Column(name = "facilities", nullable = false, length = 30)
	private String facilities;
	
	@Lob
	@Column(name = "denah", nullable = true)
	private String denah;
	
	@Column(name = "longitude", nullable = true,length= 50)
	private String longitude;

	@Column(name = "latitude", nullable = true, length= 50)
	private String latitude;
	
	@Column(name = "jumlahPembeli", nullable = false)
	private int totalPembeli;
	
	@Column(name = "openhour_start", nullable = true)
	private Time openhour_start;
	
	@Column(name = "openhour_end", nullable = true)
	private Time openhour_end;
	
	@Column(name = "payment_source", nullable = true , length = 10)
	private String payment_source;
	
	@Column(name = "seat_count", nullable = true , length = 3)
	private int seat_count;
	
	public int getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}

	public String getPayment_source() {
		return payment_source;
	}

	public void setPayment_source(String payment_source) {
		this.payment_source = payment_source;
	}

	public Time getOpenhour_start() {
		return openhour_start;
	}

	public void setOpenhour_start(Time openhour_start) {
		this.openhour_start = openhour_start;
	}

	public Time getOpenhour_end() {
		return openhour_end;
	}

	public void setOpenhour_end(Time openhour_end) {
		this.openhour_end = openhour_end;
	}

	public int getTotalPembeli() {
		return totalPembeli;
	}

	public void setTotalPembeli(int totalPembeli) {
		this.totalPembeli = totalPembeli;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Users getUsersFkId() {
		return usersFkId;
	}

	public void setUsersFkId(Users usersFkId) {
		this.usersFkId = usersFkId;
	}

//	public List<Promo> getPromoFkId() {
//		return promoIdFk;
//	}
//
//	public void setPromoFkId(List<Promo> promoFkId) {
//		this.promoIdFk = promoFkId;
//	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getRestaurantRating() {
		return restaurantRating;
	}

	public void setRestaurantRating(int restaurantRating) {
		this.restaurantRating = restaurantRating;
	}

	public String getRestaurantAddress() {
		return restaurantAddress;
	}

	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}

	public String getRestaurantPictures() {
		return restaurantPictures;
	}

	public void setRestaurantPictures(String restaurantPictures) {
		this.restaurantPictures = restaurantPictures;
	}

	public String getRestaurantDesc() {
		return restaurantDesc;
	}

	public void setRestaurantDesc(String restaurantDesc) {
		this.restaurantDesc = restaurantDesc;
	}

	public String getRestaurantKota() {
		return restaurantKota;
	}

	public void setRestaurantKota(String restaurantKota) {
		this.restaurantKota = restaurantKota;
	}

	public String getCuisinesType() {
		return cuisinesType;
	}

	public void setCuisinesType(String cuisinesType) {
		this.cuisinesType = cuisinesType;
	}

	public String getCostStart() {
		return costStart;
	}

	public void setCostStart(String costStart) {
		this.costStart = costStart;
	}

	public String getCostEnd() {
		return costEnd;
	}

	public void setCostEnd(String costEnd) {
		this.costEnd = costEnd;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getDenah() {
		return denah;
	}

	public void setDenah(String denah) {
		this.denah = denah;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	
	

}
