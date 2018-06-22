package org.vrpowerz.todo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Venkataraghavan Yanamandram Ramasubbu
 *
 */

@SpringBootApplication
@ComponentScan("org.vrpowerz.todo")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
