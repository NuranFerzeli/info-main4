package com.firstnews.info.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class TedbirImagesModel implements Comparable<TedbirImagesModel> {
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

    Long id;
    String imageName;

    @Override
    public int compareTo(TedbirImagesModel o) {
        return 0;
    }
}
