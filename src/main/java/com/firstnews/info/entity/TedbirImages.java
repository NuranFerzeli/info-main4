package com.firstnews.info.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tedbirImages")
public class TedbirImages {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tedbirId")
    private Long tedbirId;
    @Column(name = "imageName",length=400)
    private String imageName;
    @Column(name = "status_id")
    private Long status_id;

}
