package com.activeedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories

@SpringBootApplication
public class ActiveEdgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveEdgeApplication.class, args);
	}

}
