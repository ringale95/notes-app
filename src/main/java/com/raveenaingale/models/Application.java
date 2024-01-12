package com.raveenaingale.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String company;
    private String status;
    private String link;
    @Column(columnDefinition = "DATE")
    private LocalDate creationDate;

}
