package com.naf.project.model;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    public Project() {
    }

    public Project(String projectName) {
        this.name = projectName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
