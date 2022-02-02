package com.firstnews.info.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "assembleImages")
public class AssembleImages {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "imageId")
    private Long imageId;
    @NotNull
    @Column(name = "imageName",length = 400)
    String assembleName;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    LocalDate cdate;
    @Column(name = "udate")
    LocalDate udate;
}
