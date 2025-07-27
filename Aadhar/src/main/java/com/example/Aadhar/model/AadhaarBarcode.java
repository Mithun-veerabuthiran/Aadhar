package com.example.Aadhar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "aadhaar_barcodes")


public class AadhaarBarcode {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String aadhaarNumber;

	    @Lob
	    @Column(columnDefinition = "BLOB")
	    private byte[] barcodeImage;  // Store barcode as a binary image

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getAadhaarNumber() { return aadhaarNumber; }
	    public void setAadhaarNumber(String aadhaarNumber) { this.aadhaarNumber = aadhaarNumber; }

	    public byte[] getBarcodeImage() { return barcodeImage; }
	    public void setBarcodeImage(byte[] barcodeImage) { this.barcodeImage = barcodeImage; }
}
