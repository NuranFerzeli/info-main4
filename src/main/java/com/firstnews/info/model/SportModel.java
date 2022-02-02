package com.firstnews.info.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
public class SportModel {
    private String name;
    private String surname;
    private String fatherName;
    private int age;
    private LocalDate dob;
    private String detailedInformation;
    private String imageName;

    public SportModel(String name, String surname, String fatherName, int age, LocalDate dob, String detailedInformation,String imageName) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.age = age;
        this.dob = dob;
        this.detailedInformation = detailedInformation;
        this.imageName=imageName;
    }
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDetailedInformation() {
        return detailedInformation;
    }

    public void setDetailedInformation(String detailedInformation) {
        this.detailedInformation = detailedInformation;
    }
}
