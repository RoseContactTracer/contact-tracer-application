package edu.rosehulman.covidtracer.covidtracerapplication;

import edu.rosehulman.covidtracer.covidtracerapplication.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"edu.rosehulman.covidtracer.covidtracerapplication.repository"})
@EntityScan("edu.rosehulman.covidtracer.covidtracerapplication.model")
@SpringBootApplication(scanBasePackages = {"edu.rosehulman.covidtracer.covidtracerapplication.controller"})
public class CovidTracerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidTracerApplication.class, args);
		//Person example = new Person("Monty", "Python", "AndTheHolyGrail", "flyingcircus@rose-hulman.edu", "8008675309", "England");

	}

}
