package com.pixeltrice.springbootOTPapp.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.pixeltrice.springbootOTPapp.Entity.Image;
import com.pixeltrice.springbootOTPapp.Entity.Restaurant;
import com.pixeltrice.springbootOTPapp.Repository.ImageRepository;
import com.pixeltrice.springbootOTPapp.Service.ImageService;
import com.pixeltrice.springbootOTPapp.Service.RestaurantService;


@RestController
public class ImageController {
	
	@Autowired
	private ImageRepository repository;
//	
	@Autowired
	private ImageService service;
	
	@Autowired
	private RestaurantService restoservice;
//	
//    @GetMapping("/getImage/{id}")
//    public ResponseEntity<byte[]> fromDatabaseAsResEntity(@PathVariable("id") Integer id) throws SQLException {
//
//        Optional<Image> userImage = repository.findById(id);
//        byte[] imageBytes = null;
//        if (userImage.isPresent()) {
//
//            imageBytes = userImage.get().getPhoto().getBytes(1,(int) userImage.get().getPhoto().length());
//        }
//
//        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
//    }
//    
//    @PostMapping("/upload/db")
//    public ResponseEntity uploadToDB(@RequestParam("file") MultipartFile file) {
//    	Image img = new Image();
//    	img.setPhoto((Blob) file);
////    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
////    	img.setDocName(fileName);
////    	try {
////    		img.setFile(file.getBytes());
////    	} catch (IOException e) {
////    		e.printStackTrace();
////    	}
//    	repository.save(img);
//    	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//    			.path("/files/download/")
//    			.path(fileName).path("/db")
//    			.toUriString();
//    	return ResponseEntity.ok(fileDownloadUri);
//    }
//    
    @PostMapping("/getUriImages")
    public List<String> getListImages(@RequestBody Restaurant restaurant){
 		return service.getUribyId(restaurant.getRestaurantId());
    	
    }
    

}
