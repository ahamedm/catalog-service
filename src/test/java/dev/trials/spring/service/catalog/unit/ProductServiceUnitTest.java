package dev.trials.spring.service.catalog.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import dev.trials.spring.service.catalog.model.Category;
import dev.trials.spring.service.catalog.repo.CategoryRepository;
import dev.trials.spring.service.catalog.service.ProductService;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude = {FlywayAutoConfiguration.class})
public class ProductServiceUnitTest {

    @Autowired
    private ProductService service;

    @MockBean
    private CategoryRepository mockedCategoryRepo;

    @Test
    public void shouldAddProductCategorySuccessfully(){
        Category cat= new Category();
        cat.setName("Ancillary");
        when(mockedCategoryRepo.save(cat)).thenReturn(cat);
        Category added=service.addNewProductCategory(cat);
        assertThat(added).isNotNull();
    }
}