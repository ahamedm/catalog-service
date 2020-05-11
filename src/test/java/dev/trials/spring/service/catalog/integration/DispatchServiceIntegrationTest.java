package dev.trials.spring.service.catalog.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import dev.trials.spring.service.catalog.events.DomainEvent;
import dev.trials.spring.service.catalog.util.EventDispatcher;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@ActiveProfiles("itest")
@AutoConfigureStubRunner(ids={"dev.trials.spring:domain-evt-dispatch-service:+:stubs:6565"}, stubsMode = StubsMode.LOCAL)
public class DispatchServiceIntegrationTest {

	@Autowired
	EventDispatcher dispatcher;

	@Test
	public void shouldReturn400_forInvalidEvent(){
		DomainEvent evt=DomainEvent.builder().type("ProductAdded").sourceRef("catalog-service").build();
		dispatcher.publishEvent(evt);
	}

}