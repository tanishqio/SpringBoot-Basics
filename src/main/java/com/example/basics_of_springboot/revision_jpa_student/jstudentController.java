package com.example.basics_of_springboot.revision_jpa_student;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//getAllStudents()
//getStudentById(Long id)
//createStudent(Student student)
//updateStudent(Long id, Student updated)
//deleteStudent(Long id)
//
//StudentController endpoints:
//
//GET /students → 200
//GET /students/{id} → 200 or 404
//POST /students → 201
//PUT /students/{id} → 200 or 404
//DELETE /students/{id} → 204 or 404

@RestController
public class jstudentController {
    private final jstudentservice studservice;
    public jstudentController(jstudentservice studservice){
        this.studservice=studservice;
    }

    @GetMapping("/getAllStudents")
    public List<jstudent> getallstudents(){
        return studservice.getallstudents();
    }

    @PostMapping("/addnewstudent")
    public ResponseEntity<jstudent> addnewstudent(@Valid @RequestBody jstudent s){
        jstudent newstudent=studservice.createstudent(s);
            return ResponseEntity.status(201).body(newstudent);

    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<jstudent> updatestudent(@PathVariable Long id, @Valid @RequestBody jstudent s){
        jstudent updated=studservice.updatestudent(id,s);
        return ResponseEntity.status(200).body(updated);
    }

    @GetMapping("/getstudentbyid/{id}")
    public Optional<jstudent> getstudentbyid(@PathVariable Long id){
        return studservice.getstudentbyid(id);
    }

    @DeleteMapping("/deletestudentbyid/{id}")
    public void deletestudentbyid(@PathVariable Long id){
        studservice.deletestudentbyid(id);
    }
}
