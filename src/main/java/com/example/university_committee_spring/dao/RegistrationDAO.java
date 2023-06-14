package com.example.university_committee_spring.dao;

import com.example.university_committee_spring.entity.Registration;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationDAO extends CrudRepository<Registration, Integer> {

}
