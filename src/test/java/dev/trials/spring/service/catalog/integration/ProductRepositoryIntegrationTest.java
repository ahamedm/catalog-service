package dev.trials.spring.service.catalog.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import dev.trials.spring.service.catalog.model.Category;
import dev.trials.spring.service.catalog.model.Product;
import dev.trials.spring.service.catalog.model.ProductAttribute;
import dev.trials.spring.service.catalog.model.ProductType;
import dev.trials.spring.service.catalog.repo.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest(excludeAutoConfiguration = {FlywayAutoConfiguration.class}, excludeFilters = {
    @Filter(type = FilterType.REGEX, pattern="dev.trials.*.*Controller")
})
@ActiveProfiles("itest")
public class ProductRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository repository;

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

    @Test
    public void whenFindByCategoryName_ThenReturnProducts(){
        //Given
        Product product=fakeProduct();
        entityManager.persist(product);

        entityManager.flush();

        //when
        List<Product> persisted=repository.findByCategory_Name("Book");

        //then
        assertThat(persisted).isNotEmpty();
        assertThat(persisted).containsOnly(product);
    }

    @Test
    public void shouldGetAutomaticId_WhenNewProductIsPersisted(){
         //Given
        Product product=fakeProduct();
        
        Product persisted =entityManager.persist(product);
        entityManager.flush();

        //then
        assertThat(persisted).isNotNull();
        assertThat(persisted.getId()).isGreaterThan(0);
        assertThat(persisted.getAttributes()).isNotEmpty();
    }

    @Test
    public void shouldGetAutomaticId_WhenNewProductAttributeIsPersisted(){
         //Given
        Product product=fakeProduct();
        Product persisted =entityManager.persist(product);

        entityManager.flush();

        //then
        assertThat(persisted).isNotNull();
        assertThat(persisted.getId()).isGreaterThan(0);
        assertThat(persisted.getAttributes().get(0).getId()).isGreaterThan(0);
    }
}