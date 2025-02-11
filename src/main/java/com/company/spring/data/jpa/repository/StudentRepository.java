package com.company.spring.data.jpa.repository;

import com.company.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  //working with JPA
public interface StudentRepository extends JpaRepository<Student,Long> {

}
