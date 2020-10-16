package com.naf.collaborator;

import com.naf.collaborator.model.Collaborator;
import com.naf.collaborator.repository.CollaboratorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static java.util.Arrays.asList;

@SpringBootApplication
@EnableDiscoveryClient
public class CollaboratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollaboratorApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CollaboratorRepository repository) {
		return strings -> {

			List<String> collabs = asList("marouane", "khaoula", "chaima", "ayoub", "yassine");
			for (int i = 0; i < collabs.size(); i++) {
				String name = collabs.get(i);
				repository.save(new Collaborator("cin_" + name, name + "@gmail.com", name, "last " + name, (i%2 == 1) ? 1L : 2L ));
			}
		};
	}
}
