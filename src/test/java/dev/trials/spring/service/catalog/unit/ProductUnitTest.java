package dev.trials.spring.service.catalog.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

import dev.trials.spring.service.catalog.exceptions.NotEnoughStockToAllocateException;
import dev.trials.spring.service.catalog.model.Category;
import dev.trials.spring.service.catalog.model.Inventory;
import dev.trials.spring.service.catalog.model.Product;
import dev.trials.spring.service.catalog.model.ProductAttribute;
import dev.trials.spring.service.catalog.model.ProductType;

public class ProductUnitTest {

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
    public void shouldAddToInventoryQuantityAndQuantityAvailable_OnNewStock(){
        Product product=fakeProduct();
        product.stock(5);
        Inventory inventory = product.getInventory();

        assertThat(inventory.getQuantity()).isEqualTo(5);
        assertThat(inventory.getQuantityAvailable()).isEqualTo(5);
        
    }

    @Test
    public void shouldReduceQuantityAvailable_OnNewOrder(){
        Product product=fakeProduct();
        product.stock(5);
        product.placeOrder(3);
        Inventory inventory = product.getInventory();

        assertThat(inventory.getQuantity()).isEqualTo(5);
        assertThat(inventory.getQuantityAllocated()).isEqualTo(3);
        assertThat(inventory.getQuantityAvailable()).isEqualTo(2);
        
    }

    @Test
    public void shouldThrow_ProductOutOfStockToFulFill_Exception(){
        Product product=fakeProduct();
        product.stock(5);
        try{
            product.placeOrder(10);
        }catch(RuntimeException ex){
            assertThat(ex).isInstanceOf(NotEnoughStockToAllocateException.class);
        }

    }


    


}