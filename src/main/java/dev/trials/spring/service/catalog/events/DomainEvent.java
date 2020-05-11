package dev.trials.spring.service.catalog.events;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force=true)
@Builder(toBuilder = true)
@AllArgsConstructor
public class DomainEvent implements Serializable{

	@NotNull
	private long timestamp;
	@NotNull
	@Size(min = 4, max = 20)
	private String domain;
	@NotNull
	@Size(min = 4, max = 20)
	private String sourceRef;
	@NotNull
	@Size(min = 4, max = 20)
	private String type;
	private String desc;
}