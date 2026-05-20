package com.example.basics_of_springboot;

import java.util.Objects;

public class SoftwareEngineer {
    private Integer id;
    private String name;
    private String Techstack;

    public SoftwareEngineer(Integer id, String name, String techstack) {
        this.id = id;
        this.name = name;
        Techstack = techstack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechstack() {
        return Techstack;
    }

    public void setTechstack(String techstack) {
        Techstack = techstack;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(Techstack, that.Techstack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Techstack);
    }
}
