package com.company.spring.data.jpa.repository;

import com.company.spring.data.jpa.entity.Guardian;
import com.company.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  //working with JPA
public interface StudentRepository extends JpaRepository<Student,Long> {

    //inBuild CRUD operations
    List<Student> findByFirstName(String firstname);
    List<Student> findByFirstNameContaining(String firstname);
    List<Student> findByGuardianName(String name);
    void deleteById(Long id);

    //JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = :emailId")
    Student getStudentByEmailAddress(@Param("emailId") String emailId);

    //JPQL (java persistence query language)
    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);


    //JPQl
    @Query("select s.guardian from Student s where s.studentId=?1")
    Guardian getGuardianByStudentId(Long id);

    //nativeQuery

    @Query(
            value ="select last_name from tbl_student where email_address=?1",
            nativeQuery = true
    )
    String getStudentLastNameByEmailAddress(String emailId);

    //nativeQuery
    @Query(
            value = "select guardian_name from tbl_student where first_name = :first_name",
            nativeQuery = true
    )
    String getGuardianNameByFirstName(@Param("first_name") String firstname);


    @Transactional
    @Modifying
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address=?2",
            nativeQuery = true
    )
    int updateFirstNameUsingEmailId(String firstname , String emailId);


    @Transactional
    @Modifying
    @Query(
            value = "update tbl_student set guardian_email = ?1 where first_name = ?2",
            nativeQuery = true
    )
    int updateGuardianEmailAddressUsingFirstName(String guardianEmail, String firstName);

}

