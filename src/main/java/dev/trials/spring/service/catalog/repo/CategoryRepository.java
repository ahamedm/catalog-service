package dev.trials.spring.service.catalog.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.trials.spring.service.catalog.model.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category,Integer>{
    public Optional<Category> findByName(String name);
}