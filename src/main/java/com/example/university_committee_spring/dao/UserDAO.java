package com.example.university_committee_spring.dao;

import com.example.university_committee_spring.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<Users, Integer> {
}
