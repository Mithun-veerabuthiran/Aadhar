package com.example.Aadhar.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Aadhar.model.ImageEntity;
import com.example.Aadhar.repo.ImageRepo;

@Service
public class ImageService {
	   @Autowired
	    private ImageRepo imageRepository;

	    // Save image
	    public ImageEntity saveImage(MultipartFile file) throws IOException {
	        ImageEntity image = new ImageEntity(file.getOriginalFilename(), file.getBytes());
	        return imageRepository.save(image);
	    }

	    // Retrieve image by name
	    public Optional<ImageEntity> getImage(String name) {
	        return imageRepository.findByName(name);
	    }
}
	