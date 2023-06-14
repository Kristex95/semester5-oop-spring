package com.example.university_committee_spring.controller;

import com.example.university_committee_spring.dto.FacultyDto;
import com.example.university_committee_spring.dto.UsersDto;
import com.example.university_committee_spring.entity.Faculty;
import com.example.university_committee_spring.entity.Users;
import com.example.university_committee_spring.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService){
        this.usersService = usersService;
    }
    @PostMapping
    public void CreateUser(@RequestBody UsersDto usersDto){
        usersService.createUser(usersDto.getFirstName(), usersDto.getLastName(), usersDto.getEmail(), usersService.hashPassword(usersDto.getPass()), usersDto.getType_auth());
    }

    @GetMapping("/{id}")
    public Users GetUser(@PathVariable Integer id){
        return usersService.getById(id);
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.getAll();
    }

    @PutMapping("/{id}")
    public void UpdateFaculty(@PathVariable Integer id, @RequestBody UsersDto usersDto){
        usersService.updateUser(id, usersDto);
    }
}
