package com.example.Aadhar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "aadhaar_qr")
public class Aadhaar {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String aadhaarNumber;

	    @Lob
	    @Column(nullable = false)
	    private byte[] qrCode;

	    // Constructors, Getters, Setters
	    public Aadhaar() {}

	    public Aadhaar(String aadhaarNumber, byte[] qrCode) {
	        this.aadhaarNumber = aadhaarNumber;
	        this.qrCode = qrCode;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getAadhaarNumber() {
	        return aadhaarNumber;
	    }

	    public byte[] getQrCode() {
	        return qrCode;
	    }
}
