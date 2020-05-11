package dev.trials.spring.service.catalog.web;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.trials.spring.service.catalog.dto.ProductResource;
import dev.trials.spring.service.catalog.model.Category;
import dev.trials.spring.service.catalog.model.Product;
import dev.trials.spring.service.catalog.model.ProductAttribute;
import dev.trials.spring.service.catalog.model.ProductType;
import dev.trials.spring.service.catalog.service.ProductService;

@RestController
@RequestMapping("/catalog/product")

public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping(path = "/")
    public Product addNewProduct(@RequestBody ProductResource productR){
        return service.addNewProduct(toEntity(productR));
    }

    public static Product toEntity(ProductResource resource){
        Product product=new Product();
        product.setName(resource.getName());
        product.setCategory(new Category(resource.getCategory()));
        product.setType(ProductType.builder().name(resource.getType()).build());
        product.setAttributes(resource.getAttributes().stream().map(nvpair -> ProductAttribute.builder()
                    .name(nvpair.getName()).value(nvpair.getValue()).build())
                    .collect(Collectors.toList()));
        return product;
    }
}