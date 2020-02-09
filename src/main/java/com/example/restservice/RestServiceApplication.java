package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.restservice.utility.ServiceLocator;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		//On startup set a real or fake service layer.
		ServiceLocator.SetReal();
		//ServiceLocator.SetFake();
		ServiceLocator.getServiceManager().generateDemoData();
		SpringApplication.run(RestServiceApplication.class, args);
	};

}
