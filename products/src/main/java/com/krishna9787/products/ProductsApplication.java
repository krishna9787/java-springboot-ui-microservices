package com.krishna9787.products;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info=@Info(
				title="Products Microservice REST API Documentation",
				description = "Krishna9787 Products Microservice REST API Documentation",
				version="v1",
				contact = @Contact(
						name="Krishna Mohanan",
						email="krishnadasmohanan@gmail.com",
						url="test@abc.com"
				),
				license = @License(
						name="Apache2.0",
						url="abs@xyz.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "",
				url = ""
		)
)
public class ProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}

}
