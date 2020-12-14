package edu.rosehulman.covidtracer.covidtracerapplication;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import edu.rosehulman.covidtracer.postgresql.Person;
import edu.rosehulman.covidtracer.postgresql.PersonDao;

@SpringBootApplication
public class CovidTracerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidTracerApplication.class, args);
		
		PersonDao pao = new PersonDao();
		
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url("jdbc:postgresql://localhost:5432/CovidTracer");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("Nn2Nm7PaNF#^");
		
		pao.setDataSource(dataSourceBuilder.build());
		
		pao.create("Jake", "William", "Meister", "meistejw@rose-hulman.edu", "2172518560", "Address St.");
		pao.create("Billy", "William", "Meister", "meistebw@rose-hulman.edu", "2172518561", "Address St. 2");
		List list = (List) pao.selectAll();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(((Person)list.get(i)).getFirstName());
		}
	}

}
