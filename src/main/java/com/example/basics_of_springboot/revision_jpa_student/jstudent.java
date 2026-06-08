package com.example.basics_of_springboot.revision_jpa_student;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="studentz")
public class jstudent {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is Required field")
    private String name;
    @NotBlank(message = "Mail is required field")
    private String mail;
    @Min(value=18,message = "age must be above 18")
    private int age;

//    now we will be makinng a empty constructor for jpa
    public jstudent(){}
// and a constructor with parameters for our use

    public jstudent(Long id, String name, String mail, int age) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
