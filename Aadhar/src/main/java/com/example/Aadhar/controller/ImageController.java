package com.example.Aadhar.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.HttpStatus;
import com.example.Aadhar.model.ImageEntity;
import com.example.Aadhar.service.ImageService;
import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/images")
public class ImageController {
	 @Autowired
	    private ImageService imageService;

	    // Upload an image
	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
	        try {
	            ImageEntity savedImage = imageService.saveImage(file);
	            return ResponseEntity.ok("Image uploaded successfully with ID: " + savedImage.getId());
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");
	        }
	    }
	    @GetMapping("/{name}")
	    public ResponseEntity<byte[]> getImage(@PathVariable String name) {
	        Optional<ImageEntity> imageOptional = imageService.getImage(name);
	        if (imageOptional.isPresent()) {
	            ImageEntity image = imageOptional.get();
	            HttpHeaders headers = new HttpHeaders();
	            headers.add("Content-Type", "image/jpeg"); // Adjust MIME type as needed
	            return new ResponseEntity<>(image.getData(), headers, HttpStatus.OK);
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
}
