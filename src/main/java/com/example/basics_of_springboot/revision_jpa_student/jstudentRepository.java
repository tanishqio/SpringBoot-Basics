package com.example.basics_of_springboot.revision_jpa_student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jstudentRepository extends JpaRepository<jstudent,Long> {
}
