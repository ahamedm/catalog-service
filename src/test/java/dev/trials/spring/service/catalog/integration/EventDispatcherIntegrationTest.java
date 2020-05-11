package dev.trials.spring.service.catalog.integration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import dev.trials.spring.service.catalog.util.EventDispatcher;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EventTestConfiguration.class})
public class EventDispatcherIntegrationTest {

	@Autowired
	EventDispatcher dispatcher;

	@Autowired
	Environment env;
	@Test
	public void contextShouldLoadEnvironment(){
		assertTrue(env.getProperty("event.sink").endsWith("domain/event"));
	}
}