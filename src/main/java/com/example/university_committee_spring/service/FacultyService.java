package com.example.university_committee_spring.service;

import com.example.university_committee_spring.dao.FacultyDAO;
import com.example.university_committee_spring.entity.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class FacultyService {

    private final FacultyDAO facultyDAO;

    public FacultyService(FacultyDAO facultyDAO){
        this.facultyDAO = facultyDAO;
    }

    public Faculty GetFaculty(Integer id){
        return facultyDAO.findById(id).get();
    }

    public List<Faculty> GetAllFaculties(){
        return StreamSupport.stream(facultyDAO.findAll().spliterator(), false).toList();
    }

    public void CreateFaculty(String name){
        Faculty faculty = new Faculty(name);
        var fac = facultyDAO.save(faculty);
        System.out.println(fac.getId());
    }

    public void UpdateFaculty(Integer id, String name){
        Faculty faculty= facultyDAO.findById(id).get();
        faculty.setName(name);
        facultyDAO.save(faculty);
    }

    public void DeleteFaculty(Integer id){
        facultyDAO.deleteById(id);
    }
}
