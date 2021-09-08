package com.pixeltrice.springbootOTPapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pixeltrice.springbootOTPapp.Entity.Booking;
import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query(value = "SELECT 	seat_no_booking FROM booking_tbl WHERE "
			+ "booking_date =:bookdate  AND booking_hour=:bookhour "
			+ "AND restaurant_id =:restaurantId  AND booking_status <> 'DONE'", 
			nativeQuery = true)
	List<String> getbookingsfromdb(String bookhour, String bookdate, String restaurantId);

	@Query(value = "SELECT 	* FROM booking_tbl WHERE "
			+ "	booking_users_id=:users_id AND booking_status LIKE 'ISSUED' ORDER BY booking_date,booking_hour ",
			nativeQuery = true)
	List<Booking> getupcomingorders(String users_id);

	@Query(value = "SELECT 	* FROM booking_tbl WHERE "
			+ "	booking_users_id=:users_id AND (booking_status LIKE 'DONE' OR Booking_status LIKE 'CANCELLED') ORDER BY booking_date,booking_hour ",
			nativeQuery = true)
	List<Booking> gethistoryorders(String users_id);

	
}
