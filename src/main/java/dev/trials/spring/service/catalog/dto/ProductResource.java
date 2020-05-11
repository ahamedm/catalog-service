package dev.trials.spring.service.catalog.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductResource implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8424266124098771607L;
    /* TODO To be planned later */
    private String category;
    private String type;
    private String name;
    private String description;
    private float unitPrice;
    @Singular
    private List<NameValueStringPair> attributes;
}