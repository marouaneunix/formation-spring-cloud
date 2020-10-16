package com.naf.client.resource;

import java.util.List;

public class ProjectDetails {

    public Long projectId;
    public String projectName;
    public List<CollaboratorDTO> members;

    public ProjectDetails(Long projectId, String projectName, List<CollaboratorDTO> members) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.members = members;
    }
}
