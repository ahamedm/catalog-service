package dev.trials.spring.service.catalog.util;

import dev.trials.spring.service.catalog.events.DomainEvent;

public interface EventDispatcher {
	public void publishEvent(DomainEvent event);
}