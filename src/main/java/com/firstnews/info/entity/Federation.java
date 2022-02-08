package com.firstnews.info.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "federeation")
public class Federation {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "context")
    private String text;
    @Column(name = "imagePath")
    private String imagePath;
    @Column(name = "name",length=4000)
    private String name;

}
