package dev.trials.spring.service.catalog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import dev.trials.spring.service.catalog.events.DomainEvent;

@Component
public class EventDispatcherImpl implements EventDispatcher {

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	@Autowired
	Environment env;

	@Override
	public void publishEvent(DomainEvent event) {
		/* @TODO Auto-generated method stub */
		if(env.getProperty("event.publish", Boolean.class, false)){
			restTemplateBuilder.build().postForEntity(env.getProperty("event.sink"), event, String.class);
		}
	}

}