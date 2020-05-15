package com.tcs.demo.directorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class DirectorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectorioApplication.class, args);
	}

	//@Bean
	/*public CommandLineRunner demo(AddressDORepository addressDORepository, PersonDORepository personDORepository) {
		return args -> {
			System.out.println("Persons: ");
			personDORepository.findAll().forEach(person -> System.out.println(person));

			System.out.println("Addresses: ");
			addressDORepository.findAll().forEach(address -> System.out.println(address));
		};
	}*/

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}

