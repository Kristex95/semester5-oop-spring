package com.example.university_committee_spring.dto;

import com.example.university_committee_spring.entity.Faculty;
import com.example.university_committee_spring.entity.Users;
import lombok.Data;

@Data
public class RegistrationDto {
    Integer id;
    private Integer user_id;
    private Integer faculty_id;
}
