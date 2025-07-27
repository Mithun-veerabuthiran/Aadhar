package com.example.Aadhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Aadhar.model.AadhaarBarcode;
@Repository

public interface AadhaarBarcodeRepository extends JpaRepository<AadhaarBarcode, Long> {
    AadhaarBarcode findByAadhaarNumber(String aadhaarNumber);
}