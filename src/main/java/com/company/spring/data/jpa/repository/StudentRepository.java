package com.company.spring.data.jpa.repository;

import com.company.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //working with JPA
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstname);
    public List<Student> findByFirstNameContaining(String firstname);
    public List<Student> findByGuardianName(String name);
    public void deleteById(Long id);
}
