package com.example.Papeleria_Jhon;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class papeleriaJhonApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(papeleriaJhonApplication.class, args);
	}

	private static void loadEnv() {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("BD_URL", dotenv.get("BD_URL"));
		System.setProperty("BD_USERNAME", dotenv.get("BD_USERNAME"));
		System.setProperty("BD_PASSWORD", dotenv.get("BD_PASSWORD"));
	}

}
