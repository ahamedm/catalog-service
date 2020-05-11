package dev.trials.spring.service.catalog.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import dev.trials.spring.service.catalog.model.Category;
import dev.trials.spring.service.catalog.repo.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest(excludeAutoConfiguration = {FlywayAutoConfiguration.class})
@ActiveProfiles("itest")
public class CategoryRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository repository;

    @Test
    public void whenFindByName_ThenReturnCategory(){
        //Given
        Category cat=new Category();
        cat.setName("Ancillary");
        entityManager.persist(cat);
        entityManager.flush();

        //when
        Optional<Category> persisted=repository.findByName("Ancillary");

        //then
        assertThat(persisted).isNotEmpty();
    }

}