package com.naf.collaborator.resource;

import com.naf.collaborator.model.Collaborator;
import com.naf.collaborator.repository.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/collaborators")
public class CollaboratorResource {

    private CollaboratorRepository collaboratorRepository;

    public CollaboratorResource(CollaboratorRepository collaboratorRepository) {
        this.collaboratorRepository = collaboratorRepository;
    }

    @GetMapping()
    public List<CollaboratorDTO> findAll() {
        return this.collaboratorRepository.findAll().stream().map(CollaboratorDTO::new).collect(Collectors.toList()) ;
    }

    @GetMapping("/{id}") // ur/id/fjdj
    public CollaboratorDTO findById(@PathVariable Long id) {
        return this.collaboratorRepository.findById(id).map(CollaboratorDTO::new).orElseThrow(RuntimeException::new);
    }

    @GetMapping(params = "firstName") // url?par1=djdj&par2=djdj
    public List<CollaboratorDTO> findByQuery(@RequestParam("firstName") String firstName) {
        return this.collaboratorRepository.findByFirstNameQuery(firstName).stream().map(CollaboratorDTO::new).collect(Collectors.toList());
    }


}
