package dev.trials.spring.service.catalog.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.trials.spring.service.catalog.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    List<Product> findByCategory_Name(String categoryName);
    Optional<Product> findById(Integer id);
}