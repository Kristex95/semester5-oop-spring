package com.example.university_committee_spring.dto;

import com.example.university_committee_spring.entity.Role;
import lombok.Data;

@Data
public class UsersDto {
    Integer id;
    String firstName;
    String lastName;
    String email;
    Role role;
    float school_mark;
    Integer math_mark;
    Integer english_mark;
    Integer history_mark;
    String cache;

    boolean confirmed;
    String type_auth;

    String pass;
}
