package dev.trials.spring.service.catalog.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dev.trials.spring.service.catalog.exceptions.NotEnoughStockToAllocateException;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="inventory")
@Data
@EqualsAndHashCode(exclude = {"id"}, callSuper = false)
public class Inventory extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = {CascadeType.REFRESH})
    private Product product;
    
    private Integer quantity=0;
    private Integer quantityAvailable=0;
    private Integer quantityAllocated=0;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Stock[id=%d, product='%s', quantity=%d]", id, product.getId(), quantity);
    }

    public Inventory addToStock(Integer iquantity){
        this.quantity+= iquantity;
        this.quantityAvailable+=iquantity;
        return this;
    }

    public Inventory allocateForFullfillment(Integer iquantity){
        
        if(iquantity > this.quantityAvailable){
                throw new NotEnoughStockToAllocateException(String.format("No stock to reserve/allocate quantity %d",iquantity));
        }
        this.quantityAvailable-=iquantity;
        this.quantityAllocated+=iquantity;
        return this;
    }

    public Inventory reflectOnFulfillment(Integer iquantity){
            this.quantityAllocated-=iquantity;
            this.quantity-= iquantity;
            return this;
    }

}