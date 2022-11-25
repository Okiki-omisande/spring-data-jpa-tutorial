package com.example.springdatajpatutorial.Repository;

import com.example.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
  List<Student> findByFirstname(String FirstName);
  List<Student> findByFirstnameContaining(String Name);

  List<Student> findByLastnameNotNull();

  List<Student> findByGuardianName(String name);

  List<Student> findStudentByFirstnameAndLastname(String FirstName,String LastName);

  @Query("select s from Student s where s.emailAddress=?1")
  Student getStudentsByEmailAddress(String EmailAddress);

  @Query("select s.firstname from Student s where s.emailAddress=?1")
  String getStudentsFirstNameByEmailAddress(String EmailAddress);

  @Query(
          value = "select * from tbl_student s where s.email_address = ?",
          nativeQuery = true
  )
  String getStudentsByEmailAddressNative(String Email);

  @Query(
          value = "select * from tbl_student s where s.email_address = ?",
          nativeQuery = true
  )
  String getStudentsByEmailAddressNativeNamedParam(@Param("emailAddress") String Email);

  @Modifying
  @Transactional
  @Query(
          value = "update tbl_student set firstname = ?1 where email_address = ?2",
          nativeQuery = true
  )
  int updateStudentNameByEmailAddress(String firstname, String email);
}
