package com.example.university_committee_spring.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    /*public Registration(int userId, int facultyId){
        this.userId = userId;
        this.facultyId = facultyId;

    }*/

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
