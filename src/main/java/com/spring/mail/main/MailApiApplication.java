package com.spring.mail.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.mail.*"})
public class MailApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MailApiApplication.class, args);
	}

}
