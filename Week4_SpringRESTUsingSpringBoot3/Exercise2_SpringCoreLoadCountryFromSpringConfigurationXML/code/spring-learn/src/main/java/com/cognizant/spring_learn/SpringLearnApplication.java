package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country countryUS = context.getBean("countryUS", Country.class);
        Country countryDE = context.getBean("countryDE", Country.class);
        Country countryIN = context.getBean("countryIN", Country.class);
        Country countryJP = context.getBean("countryJP", Country.class);
        LOGGER.debug("Country : {}", countryUS.toString());
        LOGGER.debug("Country : {}", countryDE.toString());
        LOGGER.debug("Country : {}", countryIN.toString());
        LOGGER.debug("Country : {}", countryJP.toString());
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("START");
		displayCountry();
	}
}
