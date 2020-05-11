package dev.trials.spring.service.catalog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;

@Entity
@Table(name="product_type")
@Data
@EqualsAndHashCode(callSuper = false,exclude = {"id"})
@Builder
public class ProductType extends AbstractEntity<Integer> {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Column(unique = true)
    private String name="default";

    @OneToMany
    @Singular
    private List<Product> products;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ProductType[id=%d, name='%s']", id, name);
    }

}