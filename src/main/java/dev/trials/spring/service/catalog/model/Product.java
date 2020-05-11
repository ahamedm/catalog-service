package dev.trials.spring.service.catalog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product",
uniqueConstraints = @UniqueConstraint(columnNames = {"name"})
)
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private Float unitPrice=0f;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST} )
    @NotNull
    private ProductType type=ProductType.builder().name("default").build();

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Category category=null;

    @OneToOne(cascade = {CascadeType.ALL})
    private Inventory stock = new Inventory();

    @OneToMany(cascade ={CascadeType.ALL})
    private List<ProductAttribute> attributes;

    @Override
    public Integer getId() {
        return id;
    }

    public Product addToCategory(Category productCategory){
        this.setCategory(productCategory);
        return this;
    }
    
    public Product addAttributes(List<ProductAttribute> attributes){
        this.attributes.addAll(attributes);
        return this;
    }

    public Product stock(Integer quantity){
        this.stock.addToStock(quantity);
        return this;
    }

    public Product placeOrder(Integer quantity){
        this.stock.allocateForFullfillment(quantity);
        return this;
    }

    public Product fulfillOrder(Integer quantity){
        this.stock.reflectOnFulfillment(quantity);
        return this;
    }

    public Inventory getInventory(){
        return this.stock;
    }
    
    @Override
    public String toString() {
        return String.format("Product[id=%d, name='%s']", id, name);
    }
    
}