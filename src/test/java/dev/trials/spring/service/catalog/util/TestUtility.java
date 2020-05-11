package dev.trials.spring.service.catalog.util;

import java.util.Arrays;

import dev.trials.spring.service.catalog.model.Category;
import dev.trials.spring.service.catalog.model.Product;
import dev.trials.spring.service.catalog.model.ProductAttribute;
import dev.trials.spring.service.catalog.model.ProductType;

public class TestUtility {

    public static Product fakeProduct(){
        Category cat=new Category();
        cat.setName("Book");
       
        ProductType type = ProductType.builder().name("Shippable").build();
        
        Product book=new Product();
        book.setCategory(cat);
        book.setName("Wings of Fire");
        book.setType(type);
        
        ProductAttribute attribute=new ProductAttribute();
        attribute.setName("copy-type");
        attribute.setValue("hard-copy");
        attribute.setProduct(book);
        book.setAttributes(Arrays.asList(attribute));

        return book;
    }

}