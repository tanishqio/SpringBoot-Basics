package com.example.basics_of_springboot.revision_jpa_student;

import com.example.basics_of_springboot.revision_basics_student.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//StudentService methods:

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

@Service
public class jstudentservice {

private final jstudentRepository studrepo;
    private final StudentService studentService;

    public jstudentservice(jstudentRepository studrepo, StudentService studentService){
    this.studrepo=studrepo;
        this.studentService = studentService;
    }
public List<jstudent> getallstudents(){
    return studrepo.findAll();
}

public Optional<jstudent> getstudentbyid(Long id){
        return studrepo.findById(id);
}
public jstudent createstudent(jstudent s){
   jstudent saved =studrepo.save(s);
    return saved;
}

public void deletestudentbyid(Long id){
         studrepo.deleteById(id);
}

public jstudent updatestudent(Long id,jstudent s){
//   jstudent existing = studrepo.findById(id).orElseThrow(()-> newstudentnotfoundexception(id));
    jstudent existing = studrepo.findById(id).orElse(null);
    if (existing!=null){
        existing.setName(s.getName());
        existing.setMail(s.getMail());
        existing.setAge(s.getAge());

    }
    return studrepo.save(existing);
}


}

