package com.pixeltrice.springbootOTPapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootOtpAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOtpAppApplication.class, args);
	}

}
