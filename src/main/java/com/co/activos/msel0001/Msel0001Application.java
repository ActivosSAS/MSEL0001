package com.co.activos.msel0001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@EnableJpaRepositories("com.co.activos.msel0001.infrastructure.drivenAdapters.Oracle.*")
public class Msel0001Application {

	public static void main(String[] args) {
		SpringApplication.run(Msel0001Application.class, args);
	}

}
