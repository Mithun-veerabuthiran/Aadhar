package com.example.Aadhar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Aadhar.model.Aadharreg;
import com.example.Aadhar.repo.Aadharrepo;
@CrossOrigin

@RestController
public class maincontroller {
@Autowired
Aadharrepo a;
@GetMapping("/")
List<Aadharreg> getall(){
	return a.findAll();
}
@PostMapping("/")
void adduser(@RequestBody Aadharreg i) {
	a.save(i);
}

}