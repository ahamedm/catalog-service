package dev.trials.spring.service.catalog.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import dev.trials.spring.service.catalog.dto.ProductResource;
import dev.trials.spring.service.catalog.model.Product;
import dev.trials.spring.service.catalog.web.ProductController;

public class ProductControllerUnitTest {


    @Test
    public void shouldConvertResourceToDomainModel_SimpleAttributes(){
        ProductResource resource = ProductResource.builder().name("Wings of Fire")
                                    .type("Shippable").category("Book").build();
        Product product = ProductController.toEntity(resource);

        assertThat(product.getName()).isEqualTo(resource.getName());
        assertThat(product.getType().getName()).isEqualTo(resource.getType());
        assertThat(product.getCategory().getName()).isEqualTo(resource.getCategory());
    }
    
}