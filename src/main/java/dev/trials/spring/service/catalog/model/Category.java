package dev.trials.spring.service.catalog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="category")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"}, callSuper = false)
@RequiredArgsConstructor
public class Category extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NonNull
    @Column(unique = true)
    private String name;
    
    @OneToMany
    private List<Product> products;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Category[id=%d, name='%s']", id, name);
    }
    
}