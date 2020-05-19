package com.tcs.demo.directorio;

import com.tcs.demo.directorio.dataObjects.*;
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
	public CommandLineRunner demo(PersonDORepository personDORepository, AddressRepository personLocationRepository, LocationDORepository locationDORepository) {
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

			Address address = new Address();
			address.setStreet("Sezame");
			address.setExternalNumber("500");
			address.setInternalNumber("401");
			address.setPostalCode("56610");
			address.setLocality("Colonia del mar");
			address.setCity("Naucalpan");
			address.setState("Jalisco");
			address.setCountry("MX");
			personLocationRepository.save(address);
			address = new Address();
			address.setStreet("sur 17");
			address.setExternalNumber("mza 10");
			address.setInternalNumber("lt 16");
			address.setPostalCode("56613");
			address.setLocality("Coñlonia san Miguel Xico II");
			address.setCity("Valle de Chalco");
			address.setState("Estado de México");
			address.setCountry("MX");
			personLocationRepository.save(address);

			Location personXLocation = new Location();
			personXLocation.setOwner(newPerson);
			personXLocation.setAddress(address);
			locationDORepository.save(personXLocation);

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

