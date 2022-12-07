package com.sparta.spa_spring_homework1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpaSpringHomework1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpaSpringHomework1Application.class, args);
	}

}
