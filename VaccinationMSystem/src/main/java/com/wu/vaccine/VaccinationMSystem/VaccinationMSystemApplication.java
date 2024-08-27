package com.wu.vaccine.VaccinationMSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class VaccinationMSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationMSystemApplication.class, args);
	}

}
