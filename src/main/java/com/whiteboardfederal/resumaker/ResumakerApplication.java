package com.whiteboardfederal.resumaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.whiteboardfederal.resumaker.*")
@EnableSwagger2
public class ResumakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumakerApplication.class, args);
	}

	// Swagger
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.whiteboardfederal.resumaker"))
				.build();
	}
}
