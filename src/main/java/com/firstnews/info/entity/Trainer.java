package com.firstnews.info.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "trainers")
public class Trainer {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",length = 50)
    String name;
    @Column(name = "surName",length = 100)
    String surName;
    @Column(name = "fatherName",length = 50)
    String fatherName;
    @Column(name="age")
    int age;
    @Column(name = "dob")
    LocalDate dob;
    @Column(name="deteailedInformation",length=50000)
    String detailedInformation;
    @Column(name="status_id")
    private Long status_id;
    @Column(name = "imagePath",length=400)
    private String imagePath;
    LocalDate cdate;
    @Column(name = "udate")
    LocalDate udate;
}