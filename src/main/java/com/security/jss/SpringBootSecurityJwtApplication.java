package com.security.jss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityJwtApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootSecurityJwtApplication.class);

	public static void main(String[] args) {
		System.out.println("이거 되는거야??");
		logger.info("이거 왜 안되냐");
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
		System.out.println("이거 되는거야??");
	}
}