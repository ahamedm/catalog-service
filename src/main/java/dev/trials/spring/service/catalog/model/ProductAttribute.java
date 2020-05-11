package dev.trials.spring.service.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_attribute")
@Data
@EqualsAndHashCode(exclude = {"id","product"},callSuper = false)
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class ProductAttribute extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id=null;
    @NotNull
    @Column
    private String name;
    @NotNull
    @Column
    private String value;
    
    @ManyToOne
    private Product product=null;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ProductAttribute[id=%d, product=%d, name='%s', value='%s]", id, product.getId(), name, value);
    }
}