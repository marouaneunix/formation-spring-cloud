package com.naf.client.openclient;


import com.naf.client.resource.CollaboratorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${client.collaborator.name}", url = "${client.collaborator.url}")
public interface CollaboratorClient {

    @GetMapping("/collaborators")
    List<CollaboratorDTO> findAll();

    @GetMapping("/collaborators/{id}")
    CollaboratorDTO findById(@PathVariable("id") Long id);

    @GetMapping(value = "/collaborators", params = "projectId")
    List<CollaboratorDTO> findByProjectId(@RequestParam("projectId") Long projectId);
}
