package com.naf.project.resource;

import com.naf.project.repository.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/projects")
public class ProjectResource {

    private ProjectRepository projectRepository;

    public ProjectResource(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/{id}")
    public ProjectDTO findById(@PathVariable Long id) {
        return this.projectRepository.findById(id).map(ProjectDTO::new).orElseThrow(RuntimeException::new);
    }

}
