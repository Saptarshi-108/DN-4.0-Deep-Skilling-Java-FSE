
package com.cognizant.hibernatevsjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.cognizant.hibernatevsjpa")
public class HibernatevsjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatevsjpaApplication.class, args);
	}

}