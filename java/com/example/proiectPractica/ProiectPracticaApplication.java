package com.example.proiectPractica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.sql.DataSource;



@SpringBootApplication
public class ProiectPracticaApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSourc;

	public static void main(String[] args) {
		SpringApplication.run(ProiectPracticaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("datasource: " + dataSourc);
	}
}
