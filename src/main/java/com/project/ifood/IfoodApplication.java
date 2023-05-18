package com.project.ifood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class IfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(IfoodApplication.class, args);
	}

}
