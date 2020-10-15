package com.naf.collaborator.resource;

import com.naf.collaborator.model.Collaborator;

public class CollaboratorDTO {

    public Long collaboratorId;
    public String cin;
    public String email;
    public String firstName;
    public String lastName;

    public CollaboratorDTO(Collaborator collaborator) {
        this.collaboratorId = collaborator.getId();
        this.cin = collaborator.getCin();
        this.email = collaborator.getEmail();
        this.firstName = collaborator.getFirstName();
        this.lastName = collaborator.getLastName();
    }
}
