package com.example.Aadhar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Aadhar.model.Aadhaar;
import com.example.Aadhar.repo.AadhaarRepository;




@Service
public class AadhaarQrService {
	 @Autowired
	    private AadhaarRepository repository;

	    public Aadhaar generateAndSaveQRCode(String aadhaarNumber) throws Exception {
	        // Generate QR Code
	        byte[] qrCode = QRCodeGenerator.generateQRCode(aadhaarNumber, 200, 200);
	        
	        // Save to DB
	        Aadhaar aadhaar = new Aadhaar(aadhaarNumber, qrCode);
	        return repository.save(aadhaar);
	    }

	    public byte[] getQRCodeByAadhaarNumber(String aadhaarNumber) {
	        Aadhaar aadhaar = repository.findByAadhaarNumber(aadhaarNumber);
	        return (aadhaar != null) ? aadhaar.getQrCode() : null;
	    }

}
