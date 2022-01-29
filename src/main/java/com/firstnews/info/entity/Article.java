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
@Table(name = "article")
public class Article extends BaseEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "article_Name",length = 400)
    private String articleName;
    @Column(name = "article_Title",length = 1000)
    private String articleTitle;
    @Column(name = "article_Detail",length = 4000)
    private String articleDetail;
    @Column(name = "image_Path",length=4000)
    private String imagePath;
    @Column(name="article_Date")
    private Date newsDate;
    @Enumerated(EnumType.STRING)
    private ArticleStatus articleStatus ;
}
