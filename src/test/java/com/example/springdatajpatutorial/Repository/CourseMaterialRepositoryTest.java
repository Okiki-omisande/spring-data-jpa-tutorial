package com.example.springdatajpatutorial.Repository;

import com.example.springdatajpatutorial.entity.Course;
import com.example.springdatajpatutorial.entity.CourseMaterials;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .build();

        CourseMaterials courseMaterials =
                CourseMaterials.builder()
                        .url("www.python.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterials);
    }

    @Test
    public void printCourseMaterials() {
        List<CourseMaterials> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

}