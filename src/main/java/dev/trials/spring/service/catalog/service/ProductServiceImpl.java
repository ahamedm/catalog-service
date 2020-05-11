package dev.trials.spring.service.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.trials.spring.service.catalog.model.Category;
import dev.trials.spring.service.catalog.model.Product;
import dev.trials.spring.service.catalog.model.ProductAttribute;
import dev.trials.spring.service.catalog.repo.CategoryRepository;
import dev.trials.spring.service.catalog.repo.ProductRepository;
import dev.trials.spring.service.catalog.util.EventDispatcher;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    EventDispatcher eventDispatcher;

    @Override
    public Category addNewProductCategory(Category productCategory) {
        return categoryRepo.save(productCategory);
    }

    @Override
    public Product addProductToCategory(Category category, Integer productId) {
        Product persisted=productRepo.getOne(productId);
        persisted.setCategory(category);
        productRepo.save(persisted);
        return persisted;
    }

    @Override
    public Product addNewProduct(String name,String desc,List<ProductAttribute> attributes) {
        Product toPersist= new Product();
        toPersist.setName(name);
        toPersist.addAttributes(attributes);
        return productRepo.save(toPersist);
    }

    @Override
    public Product addNewProduct(Product product) {
        return productRepo.save(product);
    }


    @Override
    public Product addProductAttributes(Integer productId, List<ProductAttribute> attributes) {
        Product persisted=productRepo.getOne(productId);
        persisted.addAttributes(attributes);
        productRepo.save(persisted);
        return persisted;
    }

    @Override
    public Product increaseProductStock(String reference,Integer productId,Integer quantity) {
        
        return null;
    }

    @Override
    public Product allocateFromStock(String reference,Integer productId,Integer quantity) {
        
        return null;
    }

    @Override
    public Product fulfillFromStock(String reference,Integer productId,Integer quantity){
        return null;
    }

  
}