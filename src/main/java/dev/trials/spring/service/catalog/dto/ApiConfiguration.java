package dev.trials.spring.service.catalog.dto;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "apimeta")
@Data
public class ApiConfiguration implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -9125348188320688532L;
    String version;
    String description;
}