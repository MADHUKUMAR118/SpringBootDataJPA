package com.example.SpringDataJPA.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringDataJPA.Model.Person;
import com.example.SpringDataJPA.Repository.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	PersonRepo repo;
	
	@Autowired
	PasswordEncoder encoder;

	public String registerStudent(Person p) {
		  
		String password=p.getPassword();
		String hashedPassword=encoder.encode(password);
		p.setPassword(hashedPassword);
		repo.save(p);
		return "Student Registered Successfully!";
	}

	public String verifyStudent(Person p) {
		Person db=repo.findByEmail(p.getEmail());
		
		if(db!=null) {
			if(encoder.matches(p.getPassword(),db.getPassword())) {
				return "Welcome !"+": "+db.getName();
				}
			else {
				return "Invalid Password";
			}
			}
		else {
			return "Invalid Email";
		}
		
		
	}



	
	

}
