package com.example.springdatajpatutorial.Repository;

import com.example.springdatajpatutorial.entity.CourseMaterials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterials,Long> {
}
