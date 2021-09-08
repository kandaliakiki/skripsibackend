package com.pixeltrice.springbootOTPapp.Entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "image_tbl")
public class Image {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "image_id")
    private Integer id;
	
	@Column(name = "uriPhoto")
    private String uriPhoto;
	
	@Column(name = "restaurant_id")
    private String restaurant_id;

    public String getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	// Generate Getters and Setters...
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return uriPhoto;
    }

    public void setPhoto(String photo) {
        this.uriPhoto = photo;
    }
}
