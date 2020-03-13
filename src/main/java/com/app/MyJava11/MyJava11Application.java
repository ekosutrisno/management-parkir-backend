package com.app.MyJava11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MyJava11Application {

	public static void main(String[] args) {
		SpringApplication.run(MyJava11Application.class, args);
	}

}
