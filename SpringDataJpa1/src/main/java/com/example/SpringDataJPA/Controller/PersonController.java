package com.example.SpringDataJPA.Controller;




import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDataJPA.Model.Person;
import com.example.SpringDataJPA.Service.PersonService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class PersonController {
	
	@Autowired
	PersonService service;
	
	
	
	@PostMapping("/register")
	public String postMethodName(@RequestBody Person p) {
		
		
		return service.registerStudent(p);
	}
	
	@PostMapping("/verify")
	public String verifyPerson(@RequestBody Person p) {
		 return   service.verifyStudent(p);
		
	}
	

}
