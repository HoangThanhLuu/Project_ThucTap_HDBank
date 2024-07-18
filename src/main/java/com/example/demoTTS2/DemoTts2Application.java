package com.example.demoTTS2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.demoTTS2.Model")

public class DemoTts2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoTts2Application.class, args);
	}

}
