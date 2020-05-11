package dev.trials.spring.service.catalog.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameValueStringPair implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -1181160192401148570L;
    String name;
    String value;
}