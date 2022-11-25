package com.example.springdatajpatutorial.Repository;
import com.example.springdatajpatutorial.entity.Course;
import com.example.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("Python")
                .credit(3)
                .build();

        Course courseArray = Course.builder()
                .title("OOP")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstname("Lyanco")
                .lastname("Manuel")
                .build();

        teacherRepository.save(teacher);
    }

}