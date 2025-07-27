package com.example.Aadhar.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Aadhar.model.ImageEntity;

public interface ImageRepo extends JpaRepository<ImageEntity, Long> {
    Optional<ImageEntity> findByName(String name);
}