package com.naf.project;

import com.naf.project.model.Project;
import com.naf.project.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProjectRepository repository) {
		return strings -> {

			Stream.of("SIGMA","AS24").forEach(projectName -> repository.save(new Project(projectName)));
		};
	}

}
