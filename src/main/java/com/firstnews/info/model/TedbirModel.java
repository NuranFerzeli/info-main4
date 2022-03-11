package com.firstnews.info.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
public class TedbirModel {
    private String assemblyName;

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    private String shortInfo;
    private LocalDate assembleDate;
    private String assembleText;
    private Long id;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    private Long statusId;

    private String imageName ;
    public TedbirModel(String assemblyName, LocalDate assembleDate, String assembleText, Long id, String imageName) {
        this.assemblyName = assemblyName;
        this.assembleDate = assembleDate;
        this.assembleText = assembleText;
        this.id = id;
        this.imageName = imageName;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }



}
