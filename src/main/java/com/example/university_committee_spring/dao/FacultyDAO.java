package com.example.university_committee_spring.dao;

import com.example.university_committee_spring.entity.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyDAO extends CrudRepository<Faculty, Integer> {

}
