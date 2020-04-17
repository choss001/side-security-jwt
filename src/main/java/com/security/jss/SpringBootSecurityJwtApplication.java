package com.security.jss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityJwtApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootSecurityJwtApplication.class);

	public static void main(String[] args) {
		System.out.println("�̰� �Ǵ°ž�??");
		logger.info("�̰� �� �ȵǳ�");
		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
		System.out.println("�̰� �Ǵ°ž�??");
	}
}