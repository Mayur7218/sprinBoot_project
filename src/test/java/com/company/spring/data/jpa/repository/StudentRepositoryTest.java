package com.company.spring.data.jpa.repository;

import com.company.spring.data.jpa.entity.Guardian;
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
        Guardian guardian=Guardian.builder()
                .name("xyz")
                .email("xyz@gmail.com")
                .mobile("99999999")
                .build()
                ;
        Student student=Student.builder()
                .firstName("Avishkar")
                .lastName("Katkar")
                .emailId("avishkar@gmail.com")
                .guardian(guardian)
                .build();

        System.out.println(studentRepository.save(student));
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();

        System.out.println("studentList = "+studentList);
    }

    @Test
    public void printByFirstName(){
        List<Student> studentList=studentRepository.findByFirstName("Anant");
        System.out.println(studentList);
    }
    @Test
    public void printByFirstNameContaining(){
        List<Student> studentList=studentRepository.findByFirstNameContaining("Ma");
        System.out.println(studentList);
    }
    @Test
    public void findByGuardianName(){
        List<Student> studentList=studentRepository.findByGuardianName("xyz");
        System.out.println(studentList);
    }
    @Test
    public void deleteStudentByStudentId(){
        studentRepository.deleteById(7L);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("anant@gmail.com");
        System.out.println(student);
    }

    //JPQL
    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName= studentRepository.getStudentFirstNameByEmailAddress("anant@gmail.com");

        System.out.println(firstName);
    }

    @Test
    public void printGetGuardianByStudentId(){
        Guardian guardian=studentRepository.getGuardianByStudentId(1L);
        System.out.println(guardian);
    }

    @Test
    public void PrintGetStudentLastNameByEmailAddress(){
        String lastname =studentRepository.getStudentLastNameByEmailAddress("anant@gmail.com");
        System.out.println(lastname);
    }

    @Test
    public void PrintGetGuardianNameByFirstName(){
        String GuardianName= studentRepository.getGuardianNameByFirstName("Anant");
        System.out.println(GuardianName);
    }

    @Test
    public void updateFirstNameUsingEmailId(){
        int updated=studentRepository.updateFirstNameUsingEmailId("Aditya","aditya@gmail.com");

        if(updated>0){
            System.out.println("First_Name is updated");
        }else{
            System.out.println("Error in Updating");
        }
    }

    @Test
    public void PrintupdateGuardianEmailAddressUsingFirstName(){
        int updated= studentRepository.updateGuardianEmailAddressUsingFirstName("GuardianAdtiya@gmail.com","Aditya");
        if(updated>0){
            System.out.println("GuardianEmail is updated");
        }else{
            System.out.println("Error in Updating");
        }
    }


}