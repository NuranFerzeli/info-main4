package com.firstnews.info.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
public class TrainerModel {
    private String name;
    private String surname;
    private String fatherName;
    private Long id;
    private LocalDate dob;
    private String detailedInformation;
    private String imageName;
    private LocalDate udate;
    private LocalDate cdate;

    public TrainerModel(String name, String surname, String fatherName, Long id, LocalDate dob, String detailedInformation, String imageName, LocalDate cdate, LocalDate udate  ) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.id = id;
        this.dob = dob;
        this.detailedInformation = detailedInformation;
        this.imageName=imageName;
        this.cdate=cdate;
        this.udate=udate;

    }
    public LocalDate getUdate() {
        return udate;
    }

    public void setUdate(LocalDate udate) {
        this.udate = udate;
    }

    public LocalDate getCdate() {
        return cdate;
    }

    public void setCdate(LocalDate cdate) {
        this.cdate = cdate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAge() {
        return id;
    }

    public void setAge(Long id) {
        this.id = id;
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
