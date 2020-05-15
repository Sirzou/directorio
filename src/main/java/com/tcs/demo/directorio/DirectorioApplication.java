package com.tcs.demo.directorio;

import com.tcs.demo.directorio.dataObjects.Person;
import com.tcs.demo.directorio.dataObjects.PersonDORepository;
import com.tcs.demo.directorio.dataObjects.PersonLocation;
import com.tcs.demo.directorio.dataObjects.PersonLocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class DirectorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectorioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonDORepository personDORepository, PersonLocationRepository personLocationRepository) {
		return args -> {
			Person newPerson = new Person();
			newPerson.setFirstName("Saul");
			newPerson.setLastName("Martinez");
			newPerson.setAge(26);
			newPerson.setBloodType("O+");
			System.out.println(newPerson);
			personDORepository.save(newPerson);
			newPerson = new Person();
			newPerson.setFirstName("Martha");
			newPerson.setLastName("Jimenez");
			newPerson.setAge(25);
			newPerson.setBloodType("A-");
			System.out.println(newPerson);
			personDORepository.save(newPerson);
			//System.out.println(savedPerson);

			System.out.println("Persons: ");
			personDORepository.findAll().forEach(person -> System.out.println(person));

			PersonLocation address = new PersonLocation();
			address.setStreet("Sezame");
			address.setExternalNumber("500");
			address.setInternalNumber("401");
			address.setPostalCode("56610");
			address.setLocality("Colonia del mar");
			address.setCity("Naucalpan");
			address.setState("Jalisco");
			address.setCountry("MX");
			address.setOwner(newPerson);
			personLocationRepository.save(address);
			address = new PersonLocation();
			address.setStreet("sur 17");
			address.setExternalNumber("mza 10");
			address.setInternalNumber("lt 16");
			address.setPostalCode("56613");
			address.setLocality("Coñlonia san Miguel Xico II");
			address.setCity("Valle de Chalco");
			address.setState("Estado de México");
			address.setCountry("MX");
			personLocationRepository.save(address);

			System.out.println("Addresses: ");
			personLocationRepository.findAll().forEach(addressIt -> System.out.println(addressIt));
		};
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}

