package edu.rosehulman.covidtracer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.rosehulman.covidtracer.model.Person;

@SpringBootApplication
@EntityScan("/edu.rosehulman.covidtracer.model")
@EnableJpaRepositories("/edu.rosehulman.covidtracer.repository")
public class CovidTracerApplication {

	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path", "/rosehulman");
		SpringApplication.run(CovidTracerApplication.class, args);
		//Person example = new Person("Monty", "Python", "AndTheHolyGrail", "flyingcircus@rose-hulman.edu", "8008675309", "England");

	}

}
