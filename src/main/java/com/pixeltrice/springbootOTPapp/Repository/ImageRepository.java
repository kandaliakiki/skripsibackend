package com.pixeltrice.springbootOTPapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
	
	@Query(value = "SELECT uri_photo FROM image_tbl WHERE restaurant_id=:restaurant_id", nativeQuery = true)
	List<String> findUriById(String restaurant_id);
	
	@Query(value = "SELECT 	restaurant_id FROM restaurant_tbl ORDER BY RAND()  LIMIT :count", nativeQuery = true)
	List<Integer> getrestaurantrandomorder(int count);

	
	@Query(value = "SELECT 	restaurant_pictures FROM restaurant_tbl  WHERE restaurant_id=:restaurant_id", nativeQuery = true)
	String getrestaurantimagerandomorder(String restaurant_id);
	
	@Query(value = "SELECT 	restaurant_name FROM restaurant_tbl  WHERE restaurant_id=:restaurant_id", nativeQuery = true)
	List<Integer> getrestaurantnamerandomorder(String restaurant_id);
}
