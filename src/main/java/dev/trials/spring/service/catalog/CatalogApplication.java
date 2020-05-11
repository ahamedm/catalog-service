package dev.trials.spring.service.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import dev.trials.spring.service.catalog.dto.ApiConfiguration;

@SpringBootApplication(exclude={FlywayAutoConfiguration.class})
@EnableConfigurationProperties(ApiConfiguration.class)
public class CatalogApplication {

	public RestTemplateBuilder restTemplateBuilder(){
		return new RestTemplateBuilder();
	}

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}

}
