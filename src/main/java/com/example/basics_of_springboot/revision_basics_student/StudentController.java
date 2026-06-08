package com.example.basics_of_springboot.revision_basics_student;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/getall")
    public List<Student> getall(){
        return studentService.getallstudents();
    }

    @GetMapping("studentbyid/{id}")
    public Student getbyid(@PathVariable int id){
        return studentService.getstudentbyid(id);
    }

    @PostMapping("/addstudent")
    public ResponseEntity<Student> addstudent(@Valid @RequestBody Student s){
        Student news=studentService.createStudent(s);
        return ResponseEntity.status(201).body(news);
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updatevalue(@PathVariable int id,@RequestBody Student updated){
        Student s=studentService.getstudentbyid(id);
        if(s==null) {
            return ResponseEntity.status(404).body(null);
        }
        Student update=studentService.updateStudent(id,updated);
            return ResponseEntity.status(200).body(update);


    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deletebyid(@PathVariable int id){
        Student s=studentService.getstudentbyid(id);
        if(s==null){
            return ResponseEntity.status(404).body("No student found with this id");
        }
        studentService.deletebyid(id);
        return ResponseEntity.status(204).body("Deleted student");
    }


}
