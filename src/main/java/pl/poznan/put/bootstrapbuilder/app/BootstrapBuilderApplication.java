package pl.poznan.put.bootstrapbuilder.app;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main BootstrapBuilder class, responsible for connecting Spring Boot and Vaadin
 *
 * @author Jan Śmiełowski, Mikołaj Szymczak
 * @version 1.1
 */
@EnableVaadin({"pl.poznan.put.bootstrapbuilder.GUI"})
@SpringBootApplication
public class BootstrapBuilderApplication {

    /**
     * Main method, connecting Spring to application
     *
     * @param args parameters for the program (empty for normal boot)
     */
	public static void main(String[] args) {
		SpringApplication.run(BootstrapBuilderApplication.class, args);
	}

}
