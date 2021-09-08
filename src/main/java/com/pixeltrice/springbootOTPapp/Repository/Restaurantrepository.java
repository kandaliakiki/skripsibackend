package com.pixeltrice.springbootOTPapp.Repository;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;

@Repository
public interface Restaurantrepository extends JpaRepository<Restaurant, Integer> {

	@Query(value = "SELECT 	restaurant_id FROM restaurant_tbl ORDER BY RAND()  LIMIT :count", nativeQuery = true)
	List<String> getrestaurantrandomorder(int count);

	@Query(value = "SELECT 	restaurant_id FROM restaurant_tbl  LIMIT :count", nativeQuery = true)
	List<String> getrestaurantbyorder(int count);
	
	@Query(value = "SELECT uri_photo FROM image_tbl  WHERE restaurant_id = :restaurantid", nativeQuery = true)
	List<String> getallimgresto(String restaurantid);
	
	Optional<Restaurant> findByrestaurantId(String id);

	@Query(value = "SELECT uri_photo FROM image_tbl  WHERE restaurant_id = :restaurantid LIMIT :count", nativeQuery = true)
	List<String> getallimgrestowihtlimit(String restaurantid, int count);

	@Query(value = "SELECT payment_source_name FROM payment_source_tbl  WHERE payment_source_id = :paysrc_id", nativeQuery = true)
	String getpaymentnamefromdb(String paysrc_id);

	@Query(value = "SELECT * FROM restaurant_tbl  WHERE upper(restaurant_name) LIKE %:restoname%", nativeQuery = true)
	List<Restaurant> searchresto(String restoname);
	
	@Query(value = "SELECT * FROM restaurant_tbl ", nativeQuery = true)
	List<JSONObject> getrestaurantjson();

	@Query(value = "select * from restaurant_tbl rt where rt.restaurant_id  in (select restaurant_id  "
			+ "from booking_tbl bt where bt.booking_date = :date and bt.booking_hour = :hour and UPPER(booking_status) like 'ISSUED' ) ", nativeQuery = true)
	List<Restaurant> getrestowbooking(String date, String hour);

	
	@Query(value = "select count(*) from booking_tbl bt where bt.booking_date = :date "
			+ "	and bt.booking_hour = :hour and upper(restaurant_id) like :restaurantId  and UPPER(booking_status) like 'ISSUED'", nativeQuery = true)
	String getcountbook(String date, String hour, String restaurantId);
	
}
