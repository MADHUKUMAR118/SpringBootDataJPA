package com.example.SpringDataJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringDataJPA.Model.Person;

@Repository
public interface PersonRepo   extends JpaRepository<Person,Integer> {

	Person findByEmail(String  email);

}
