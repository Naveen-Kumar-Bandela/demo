package com.spring.resilience4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringResilience4jApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringResilience4jApplication.class, args);
	}

}
