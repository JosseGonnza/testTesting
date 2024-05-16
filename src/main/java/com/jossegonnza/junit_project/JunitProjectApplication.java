package com.jossegonnza.junit_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(JunitProjectApplication.class, args);

		double salary = 1000;

		System.out.println(MoneyUtil.format(salary));
	}

}
