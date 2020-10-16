package com.naf.collaborator.model;

import javax.persistence.*;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String cin;
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private Long projectId;

    public Collaborator() {
    }

    public Collaborator(String cin, String email, String firstName, String lastName, Long projectId) {
        this.cin = cin;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public String getCin() {
        return cin;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getProjectId() {
        return projectId;
    }
}
