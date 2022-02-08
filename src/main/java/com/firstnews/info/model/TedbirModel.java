package com.firstnews.info.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@ToString
public class TedbirModel {
    private String assemblyName;
    private LocalDate assembleDate;
    private String assembleText;
    private Long id;
    private String imageName [];

    public TedbirModel() {

    }

    public String getAssemblyName() {
        return assemblyName;
    }

    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
    }

    public LocalDate getAssembleDate() {
        return assembleDate;
    }

    public void setAssembleDate(LocalDate assembleDate) {
        this.assembleDate = assembleDate;
    }

    public String getAssembleText() {
        return assembleText;
    }

    public void setAssembleText(String assembleText) {
        this.assembleText = assembleText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getImageName() {
        return imageName;
    }

    public void setImageName(String[] imageName) {
        this.imageName = imageName;
    }

    public TedbirModel(String assemblyName, LocalDate assembleDate, String assembleText, Long id, String[] imageName) {
        this.assemblyName = assemblyName;
        this.assembleDate = assembleDate;
        this.assembleText = assembleText;
        this.id = id;
        this.imageName = imageName;
    }


}
