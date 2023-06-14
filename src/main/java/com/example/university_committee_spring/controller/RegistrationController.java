package com.example.university_committee_spring.controller;

import com.example.university_committee_spring.dto.RegistrationDto;
import com.example.university_committee_spring.dto.UsersDto;
import com.example.university_committee_spring.entity.Registration;
import com.example.university_committee_spring.entity.Users;
import com.example.university_committee_spring.service.RegistrationService;
import com.example.university_committee_spring.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }
    @PostMapping
    public void createRegistration(@RequestBody RegistrationDto registrationDto){
        registrationService.createRegistration(registrationDto.getUser_id(), registrationDto.getFaculty_id());
    }

    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable Integer id){
        return registrationService.getRegistration(id);
    }

    @GetMapping
    public List<Registration> getAllUsers(){
        return registrationService.getAllRegistrations();
    }

    @PutMapping("/{id}")
    public void updateRegistration(@PathVariable Integer id, @RequestBody RegistrationDto registrationDto){
        registrationService.updateRegistration(id, registrationDto);
    }
}
