package com.example.university_committee_spring.controller;

import com.example.university_committee_spring.dto.FacultyDto;
import com.example.university_committee_spring.entity.Faculty;
import com.example.university_committee_spring.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {


    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public Faculty GetFaculty(@PathVariable Integer id){
        return facultyService.GetFaculty(id);
    }

    @GetMapping
    public List<Faculty> GetAllFaculties(){
        return facultyService.GetAllFaculties();
    }

    @PostMapping
    public void CreateFaculty(@RequestBody FacultyDto facultyDto){
        facultyService.CreateFaculty(facultyDto.getName());
    }

    @PutMapping("/{id}")
    public void UpdateFaculty(@PathVariable Integer id, @RequestBody FacultyDto facultyDto){
        facultyService.UpdateFaculty(id, facultyDto.getName());
    }

    @DeleteMapping
    public void DeleteFaculty(@RequestBody FacultyDto facultyDto){
        facultyService.DeleteFaculty(facultyDto.getId());
    }
}
