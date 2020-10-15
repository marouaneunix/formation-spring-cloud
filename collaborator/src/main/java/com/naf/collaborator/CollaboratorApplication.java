package com.naf.collaborator;

import com.naf.collaborator.model.Collaborator;
import com.naf.collaborator.repository.CollaboratorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CollaboratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaboratorApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CollaboratorRepository repository) {
		return strings -> {

			Stream.of("marouane", "khaoula", "chaima", "ayoub", "yassine")
					.forEach(name -> repository.save(new Collaborator("cin_" + name, name + "@gmail.com", name, "last " + name)));
		};
	}
}
