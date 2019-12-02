package pl.poznan.put.bootstrapbuilder.app;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.poznan.put.bootstrapbuilder.rest.BootstrapBuilderController;

/**
 * Main BootstrapBuilder class, responsible for connecting Spring Boot and Vaadin
 *
 * @author Jan Śmiełowski
 * @author Mikołaj Szymczak
 * @version 1.1
 */
@SpringBootApplication(scanBasePackages = {"pl.poznan.put.bootstrapbuilder.rest"})
@ComponentScan(basePackageClasses = BootstrapBuilderController.class)
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
