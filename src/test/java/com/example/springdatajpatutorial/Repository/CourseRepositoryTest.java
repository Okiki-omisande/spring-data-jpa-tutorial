package com.example.springdatajpatutorial.Repository;

import com.example.springdatajpatutorial.entity.Course;
import com.example.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstname("Oleg")
                .lastname("Vladimir")
                .build();

        Course course = Course.builder()
                .title("VR")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

}