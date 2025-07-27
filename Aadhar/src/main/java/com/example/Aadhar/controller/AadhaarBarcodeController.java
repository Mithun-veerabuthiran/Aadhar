package com.example.Aadhar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Aadhar.model.AadhaarBarcode;
import com.example.Aadhar.service.AadhaarBarcodeService;

@RestController
@RequestMapping("/barcode")
public class AadhaarBarcodeController {
	 @Autowired
	    private AadhaarBarcodeService barcodeService;
	 @GetMapping("/")
	 String getall() {
		 return "final";
	 }
	 @PostMapping("/generate")
	    public ResponseEntity<String> generateBarcode(@RequestParam String aadhaarNumber) {
	        try {
	            // Ensure this method exists in the service layer
	            AadhaarBarcode barcode = barcodeService.generateAndSaveBarcode(aadhaarNumber);
	            return ResponseEntity.ok("Barcode generated and saved for Aadhaar: " + aadhaarNumber);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	        }
	    }
	 @GetMapping("/get/{aadhaarNumber}")
	    public ResponseEntity<byte[]> getBarcode(@PathVariable String aadhaarNumber) {
	        byte[] barcode = barcodeService.getBarcodeByAadhaar(aadhaarNumber);
	        if (barcode != null) {
	            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(barcode);
	        }
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
}
