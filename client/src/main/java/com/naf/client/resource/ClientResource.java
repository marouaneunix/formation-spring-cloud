package com.naf.client.resource;

import com.naf.client.openclient.CollaboratorClient;
import com.naf.client.openclient.ProjectClient;
import com.naf.client.openclient.ProjectDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    private CollaboratorClient collaboratorClient;
    private ProjectClient projectClient;

    public ClientResource(CollaboratorClient collaboratorClient, ProjectClient projectClient) {
        this.collaboratorClient = collaboratorClient;
        this.projectClient = projectClient;
    }

    @GetMapping("/collaborators")
    public List<CollaboratorDTO> findAll() {
        return this.collaboratorClient.findAll();
    }

    @GetMapping("/collaborators/{id}")
    public CollaboratorDTO findById(@PathVariable Long id) {
        return this.collaboratorClient.findById(id);
    }


    @GetMapping("/project-details/{projectId}")
    public ProjectDetails findDetailsByProjectId(@PathVariable("projectId") Long projectId) {
        // call collaborator api
        List<CollaboratorDTO> members = this.collaboratorClient.findByProjectId(projectId);
        // call project api
        ProjectDTO projectDTO = this.projectClient.findById(projectId);
        // construit dto
        return new ProjectDetails(projectDTO.projectId, projectDTO.name, members);
    }



}
