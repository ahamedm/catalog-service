package dev.trials.spring.service.catalog.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import dev.trials.spring.service.catalog.model.Inventory;

public class InventoryUnitTest {

    
    @Test
    public void shouldAddToQuantityAndQuantityAvailable_OnNewStock(){
        Inventory inventory = new Inventory();
        inventory.addToStock(5);

        assertThat(inventory.getQuantity()).isEqualTo(5);
        assertThat(inventory.getQuantityAvailable()).isEqualTo(5);
        
    }

    @Test
    public void shouldReduceQuantityAvailable_OnNewOrder(){
        Inventory inventory = new Inventory();
        inventory.addToStock(5);
        inventory.allocateForFullfillment(3);

        assertThat(inventory.getQuantity()).isEqualTo(5);
        assertThat(inventory.getQuantityAllocated()).isEqualTo(3);
        assertThat(inventory.getQuantityAvailable()).isEqualTo(2);
        
    }

    @Test
    public void shouldReduceQuantityAndQuantityAllocated_OnFulfillment(){
        Inventory inventory = new Inventory();
        inventory.addToStock(5);
        inventory.allocateForFullfillment(3);

        assertThat(inventory.getQuantity()).isEqualTo(5);
        assertThat(inventory.getQuantityAllocated()).isEqualTo(3);
        assertThat(inventory.getQuantityAvailable()).isEqualTo(2);
        
        inventory.reflectOnFulfillment(2);

        assertThat(inventory.getQuantity()).isEqualTo(3);
        assertThat(inventory.getQuantityAllocated()).isEqualTo(1);
        assertThat(inventory.getQuantityAvailable()).isEqualTo(2);
    }

}