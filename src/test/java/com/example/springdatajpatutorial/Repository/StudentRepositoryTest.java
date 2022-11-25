package com.example.springdatajpatutorial.Repository;

import com.example.springdatajpatutorial.entity.Guardian;
import com.example.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailAddress("dsadf2@gmail.com")
                .firstname("oki")
                .lastname("omis")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .mobile("9876453738")
                .email("rola@gmail.com")
                .name("rola")
                .build();

        Student student2 = Student.builder()
                .firstname("chike")
                .lastname("dike")
                .emailAddress(("chikedike9@gmail.com"))
                .guardian(guardian)
                .build();

        studentRepository.save(student2);
    }
    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void PrintStudentByFirstname() {
        List<Student> studentList = studentRepository.findByFirstname("oki");
        System.out.println(studentList);
    }

    @Test
    public void PrintStudentByFirstnameContaining() {
        List<Student> studentList = studentRepository.findByFirstnameContaining("okiki");
        System.out.println(studentList);
    }

    @Test
    public void PrintStudentByLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastnameNotNull();
        System.out.println(studentList);
    }

    @Test
    public void PrintStudentByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("rola");
        System.out.println(studentList);
    }

    @Test
    public void PrintStudentByFirstNameAndLastName() {
        List<Student> studentList = studentRepository.findStudentByFirstnameAndLastname("okiki","omisande");
        System.out.println(studentList);
    }
    
    @Test
    public void PrintStudentsByEmailAddress() {
        Student student = studentRepository.getStudentsByEmailAddress("okikiomisande8@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void PrintStudentsFirstByEmailAddress() {
        String firstName = studentRepository.getStudentsFirstNameByEmailAddress("okikiomisande8@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void PrintStudentByEmailAddressNative() {
        String student = studentRepository.getStudentsByEmailAddressNative("okiki2@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void PrintStudentByEmailAddressNativeNamedParam() {
        String student = studentRepository.getStudentsByEmailAddressNativeNamedParam("okiki2@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmail() {
        studentRepository.updateStudentNameByEmailAddress("Elijah","okiki2@gmail.com");
    }
}