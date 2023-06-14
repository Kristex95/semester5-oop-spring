package com.example.university_committee_spring.service;

import com.example.university_committee_spring.dao.UserDAO;
import com.example.university_committee_spring.dto.UsersDto;
import com.example.university_committee_spring.entity.Faculty;
import com.example.university_committee_spring.entity.Role;
import com.example.university_committee_spring.entity.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UsersService {

    private final UserDAO userDAO;

    @Autowired
    public UsersService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Users getById(Integer id) {
        return userDAO.findById(id).get();
    }
    /*
    public List<Users> getAllUnconfirmedUsers(){

    }
    */

    public void confirmUser(int id) {
        Users user = userDAO.findById(id).orElse(null);
        user.setConfirmed(true);
        userDAO.save(user);
    }


    public void updateUser(Integer id, UsersDto user){
        Users existingUser = userDAO.findById(id).orElse(null);
        BeanUtils.copyProperties(user, existingUser, "id");
        userDAO.save(existingUser);
    }

    public void createUser(String firstName, String lastName, String email, String hashPassword, String type_auth) {
        Users user = new Users(firstName, lastName, email, hashPassword, type_auth);
        user.setRole(Role.ABITURIENT);
        userDAO.save(user);
    }

    public List<Users> getAll() {
        return StreamSupport.stream(userDAO.findAll().spliterator(), false).toList();
    }

    /*public static Users getByEmail(String email, String auth_type){

    }*/

    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedByte = digest.digest(password.getBytes("UTF-8"));
            String hashedPassword = Base64.getEncoder().encodeToString(hashedByte);
            return hashedPassword;
        } catch (Exception e) {
            System.out.println("hash :" + e);
            return null;
        }
    }

    public void deleteUser(Integer id){
        userDAO.deleteById(id);
    }
}
