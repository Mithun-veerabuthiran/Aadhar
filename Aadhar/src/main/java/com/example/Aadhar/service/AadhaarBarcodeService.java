package com.example.Aadhar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Aadhar.model.AadhaarBarcode;

import com.example.Aadhar.repo.AadhaarBarcodeRepository;


@Service
public class AadhaarBarcodeService {
	  @Autowired
	    private AadhaarBarcodeRepository repository;

	    // ✅ Properly defined method to generate and save barcode
	    public AadhaarBarcode generateAndSaveBarcode(String aadhaarNumber) throws Exception {
	        byte[] barcode = BarcodeGenerator.generateBarcode(aadhaarNumber);

	        AadhaarBarcode entity = new AadhaarBarcode();
	        entity.setAadhaarNumber(aadhaarNumber);
	        entity.setBarcodeImage(barcode);

	        return repository.save(entity);  // ✅ This ensures the barcode is stored in the database
	    }

	    // ✅ Define this method to fetch barcode from the database
	    public byte[] getBarcodeByAadhaar(String aadhaarNumber) {
	        AadhaarBarcode record = repository.findByAadhaarNumber(aadhaarNumber);
	        return (record != null) ? record.getBarcodeImage() : null;
	    }
}
