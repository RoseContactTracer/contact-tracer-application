package edu.rosehulman.covidtracer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EntityScan("/edu.rosehulman.covidtracer.model")
@EnableJpaRepositories("/edu.rosehulman.covidtracer.repository")
public class CovidTracerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidTracerApplication.class, args);

	}

}
