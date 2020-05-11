package dev.trials.spring.service.catalog.service;

import java.util.List;

import dev.trials.spring.service.catalog.model.Category;
import dev.trials.spring.service.catalog.model.Product;
import dev.trials.spring.service.catalog.model.ProductAttribute;

public interface ProductService {
    Category addNewProductCategory(Category productCategory);
    Product addProductToCategory(Category category, Integer productId);
    Product addProductAttributes(Integer productId, List<ProductAttribute> attributes);
    Product addNewProduct(String name,String desc,List<ProductAttribute> attributes);
    Product increaseProductStock(String reference,Integer productId,Integer quantity);
    Product allocateFromStock(String reference,Integer productId,Integer quantity);
    Product fulfillFromStock(String reference,Integer productId,Integer quantity);

    Product addNewProduct(Product product);
}