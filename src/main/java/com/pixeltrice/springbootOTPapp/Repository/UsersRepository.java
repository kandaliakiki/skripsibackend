package com.pixeltrice.springbootOTPapp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

	@Query(value = "SELECT count(*) FROM users_tbl WHERE users_email=:email ", nativeQuery = true)
	int finduserbyemail(String email);
	
	@Query(value = "SELECT * FROM users_tbl WHERE users_email=:email ", nativeQuery = true)
	Users getuseridbyemail(String email);

	@Query(value = "SELECT * FROM users_tbl WHERE users_phone=:phoneno ", nativeQuery = true)
	Users getuseridbyphoneno(String phoneno);
	
	
	@Query(value = "SELECT * FROM users_tbl WHERE users_email=:email  and users_password= :password", nativeQuery = true)
	Users userloginbyemail(String email,String password);

	@Query(value = "SELECT * FROM users_tbl WHERE users_phone=:phoneno", nativeQuery = true)
	Users userloginbyphone(String phoneno);

	

//	Optional<Restaurant> findByrestaurantId(String id);
//	Optional<Users> findByusers_id(String email);
//	Optional<Restaurant> findByrestaurantId(String id);

}
