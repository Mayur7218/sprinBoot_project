package com.company.spring.data.jpa.repository;

import com.company.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //working with JPA
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstname);
    List<Student> findByFirstNameContaining(String firstname);
    List<Student> findByGuardianName(String name);
    void deleteById(Long id);

    @Query("SELECT s FROM Student s WHERE s.emailId = :emailId")
    Student getStudentByEmailAddress(@Param("emailId") String emailId);

    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = :emailId")
    String getStudentFirstNameByEmailAddress(@Param("emailId") String emailId);
}

