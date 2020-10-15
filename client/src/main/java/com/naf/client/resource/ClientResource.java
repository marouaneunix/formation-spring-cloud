package com.naf.client.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    private static final String COLLABORATOR_URL = "http://localhost:8080/collaborators";
    private static final String COLLABORATOR_URL_with_id = "http://localhost:8080/collaborators/{id}";
    private RestTemplate restTemplate;

    public ClientResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/collaborators")
    public List<CollaboratorDTO> findAll() {
        return Arrays.asList(restTemplate.getForEntity(COLLABORATOR_URL, CollaboratorDTO[].class).getBody());
    }

    @GetMapping("/collaborators/{id}")
    public CollaboratorDTO findById(@PathVariable Long id) {
        return restTemplate.getForEntity(COLLABORATOR_URL_with_id, CollaboratorDTO.class, id).getBody();
    }



}
