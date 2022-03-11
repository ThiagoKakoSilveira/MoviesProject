package com.silveirasolutions.dsmovie.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private Double score;
    @Getter @Setter
    private Integer count;
    @Getter @Setter
    private String image;

    @Getter
    @OneToMany(mappedBy = "id.movie")
    private Set<Score> scores = new HashSet<>();

}