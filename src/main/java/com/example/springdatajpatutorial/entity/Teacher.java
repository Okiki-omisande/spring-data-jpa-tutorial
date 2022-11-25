package com.example.springdatajpatutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Teacher {
   @Id
   @SequenceGenerator(
           name = "teacher_sequence",
           sequenceName = "teacher_sequence",
           allocationSize = 1
   )

   @GeneratedValue(
           strategy = SEQUENCE,
           generator = "teacher_sequence"
   )
    private Long teacherId;
    private String firstname;
    private String lastname;

   /*  @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_Id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;
    */

}
