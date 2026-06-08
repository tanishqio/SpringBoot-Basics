package com.example.basics_of_springboot.revision_basics_student;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
private List<Student> students = new ArrayList<>(List.of(
        new Student(1,"fsd","fsdf",20),
         new Student(2,"saksham","nail",90)              ));

public List<Student> getallstudents(){
    return students;
}
public Student getstudentbyid(int id){
    return students.stream().filter(s->s.getId()==id).findFirst().orElse(null);
}

public Student createStudent(Student s){
students.add(s);
return s;
}

public Student updateStudent(int id, Student updated){
    int ind=-1;
    for(int i=0;i<students.size();i++){
        if(students.get(i).getId()==id){
            ind=id;
            break;
        }
    }
    if(ind!=-1){
        students.set(ind,updated);
    }
    return updated;
}

public void deletebyid(int id){
    int ind=-1;
    for(int i=0;i<students.size();i++){
        if(students.get(i).getId()==id){
            ind=i;
            break;
        }
    }
    if(id==-1){
        students.remove(ind);
    }
}
}

