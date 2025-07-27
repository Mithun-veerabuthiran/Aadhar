package com.example.Aadhar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Aadhar.service.AadhaarQrService;

@RestController
@RequestMapping("/Qr")
public class AadhaarController {
	  @Autowired
	    private AadhaarQrService service;
          @GetMapping("/")
          String getall() {
        	  return "final";
          }
	    @PostMapping("/generate")
	    public ResponseEntity<String> generateQRCode(@RequestParam String aadhaarNumber) {
	        try {
	            service.generateAndSaveQRCode(aadhaarNumber);
	            return ResponseEntity.ok("QR Code generated and stored successfully!");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Error generating QR Code: " + e.getMessage());
	        }
	    }
	    @GetMapping("/get")
	    public ResponseEntity<byte[]> getQRCode(@RequestParam String aadhaarNumber) {
	        byte[] qrCode = service.getQRCodeByAadhaarNumber(aadhaarNumber);

	        if (qrCode == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }

	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Content-Type", "image/png");

	        return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
	    }
}
