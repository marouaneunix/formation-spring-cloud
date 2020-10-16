package com.naf.project.resource;

import com.naf.project.model.Project;

public class ProjectDTO {

    public Long projectId;
    public String name;

    public ProjectDTO(Project project) {
        this.projectId = project.getId();
        this.name = project.getName();
    }
}
