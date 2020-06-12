package com.lkreski.cho.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publicationID;
    @Column
    private String author;
    @Column
    private String publicationDate;
    @Column
    private String title;
    @Column
    private String fileLocation;
    @Column(columnDefinition = "int default 1")
    private Long version;
    @Column
    private String category;

//    @ManyToOne
//    @JoinColumn(name = "userID", nullable = true)
//    private User user;
}
