package com.demo.openai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the OpenAI Spring Boot application.
 * <p>
 * This application integrates Spring AI with OpenAI to provide chat capabilities
 * through REST endpoints. The application auto-configures all necessary Spring components
 * and initializes the ChatClient for AI interactions.
 * </p>
 *
 * @author Pramod Rajane
 * @version 1.0
 * @since 2026-06-14
 */
@SpringBootApplication
public class OpenaiApplication {

	/**
	 * Main method to bootstrap the Spring Boot application.
	 * <p>
	 * This method serves as the entry point for the application and initializes
	 * the Spring application context with all configured beans and dependencies.
	 * </p>
	 *
	 * @param args Command-line arguments passed to the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(OpenaiApplication.class, args);
	}

}
