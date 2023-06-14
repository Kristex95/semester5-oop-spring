package com.example.university_committee_spring.service;

import com.example.university_committee_spring.dao.RegistrationDAO;
import com.example.university_committee_spring.dto.RegistrationDto;
import com.example.university_committee_spring.entity.Registration;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class RegistrationService {

    private final RegistrationDAO registrationDAO;

    public RegistrationService(RegistrationDAO registrationDAO){
        this.registrationDAO = registrationDAO;
    }

    public Registration getRegistration(Integer id){
        return registrationDAO.findById(id).get();
    }

    public List<Registration> getAllRegistrations(){
        return StreamSupport.stream(registrationDAO.findAll().spliterator(), false).toList();
    }

    public void createRegistration(Integer user_id, Integer faculty_id){
        Registration registration = new Registration(user_id, faculty_id);
        registrationDAO.save(registration);
    }

    public void updateRegistration(Integer id, RegistrationDto registrationDto){
        Registration existingRegistration = registrationDAO.findById(id).orElse(null);
        if (existingRegistration == null){
            return;
        }
        BeanUtils.copyProperties(registrationDto, existingRegistration, "id");
        registrationDAO.save(existingRegistration);
    }

    public void deleteRegistration(Integer id){
        registrationDAO.deleteById(id);
    }
}
