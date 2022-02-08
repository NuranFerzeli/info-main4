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
@Table(name = "assemble")
public class Tedbir {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "assembleName",length = 400)
    String assembleName;
    @Column(name="st")
    private boolean status;
    @Column(name = "cdate")
    LocalDate cdate;
    @Column(name = "udate")
    LocalDate udate;

}
