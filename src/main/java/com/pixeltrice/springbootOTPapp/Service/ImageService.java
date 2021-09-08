package com.pixeltrice.springbootOTPapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepository repository;
	
	public List<String> getUribyId(String id){
		return repository.findUriById(id);
	}
	
//	public List<String> getUrirandomorder(String count){
//		
//		return repository.getrestaurantrandomorder(Integer.parseInt(count));
//	}
//	
//	public List<Integer> getrestorandomorder(String count){
//		
//		return repository.getrestaurantrandomorder(Integer.parseInt(count));
//	}

}
