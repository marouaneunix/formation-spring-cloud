package com.naf.client.openclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${client.project.name}", url = "${client.project.url}")
public interface ProjectClient {

    @GetMapping("/projects/{id}")
    ProjectDTO findById(@PathVariable("id") Long id);

}
