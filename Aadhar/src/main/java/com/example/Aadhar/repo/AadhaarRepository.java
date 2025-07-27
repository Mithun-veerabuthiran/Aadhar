package com.example.Aadhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Aadhar.model.Aadhaar;


public interface AadhaarRepository extends JpaRepository<Aadhaar, Long> {
    Aadhaar findByAadhaarNumber(String aadhaarNumber);
}
