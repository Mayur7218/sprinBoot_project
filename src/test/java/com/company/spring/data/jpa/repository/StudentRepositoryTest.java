package com.company.spring.data.jpa.repository;

import com.company.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("mayur@gmail.com")
                .firstName("Mayur")
                .lastName("Jadhav")
                .guardianName("Rohit")
                .guardianEmail("rohit@gmail.com")
                .guardianMobile("872837821")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();

        System.out.println("studentList = "+studentList);
    }
}