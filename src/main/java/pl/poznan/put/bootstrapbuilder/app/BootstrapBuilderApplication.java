package pl.poznan.put.bootstrapbuilder.app;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableVaadin({"pl.poznan.put.bootstrapbuilder.GUI"})
@SpringBootApplication
public class BootstrapBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstrapBuilderApplication.class, args);
	}

}
