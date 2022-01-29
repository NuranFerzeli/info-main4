package com.firstnews.info.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "news")
public class News extends BaseEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "news_Name",length = 400)
    private String newsName;
    @Column(name = "news_Title",length = 1000)
    private String newsTitle;
    @Column(name = "image_Path",length=4000)
    private String imagePath;
    @Column(name="news_Date")
    private Date newsDate;
    @Enumerated(EnumType.STRING)
    private NewsStatus newsStatus ;
}
