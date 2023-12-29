package com.raveenaingale.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DataStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "notes", columnDefinition = "LONGTEXT")
    private String notes;
}
