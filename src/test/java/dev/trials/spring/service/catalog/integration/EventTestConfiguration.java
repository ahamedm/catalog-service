package dev.trials.spring.service.catalog.integration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import dev.trials.spring.service.catalog.util.EventDispatcher;
import dev.trials.spring.service.catalog.util.EventDispatcherImpl;

@ActiveProfiles("itest")
public class EventTestConfiguration {
	/* @TODO Verify usage of TestConfiguration */
	@Bean
	public RestTemplateBuilder restTemplateBuilder(){
		return new RestTemplateBuilder();
	}

	@Bean
	public EventDispatcher dispatcher(){
		return new EventDispatcherImpl();
	}
}