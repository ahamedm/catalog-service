package dev.trials.spring.service.catalog.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import dev.trials.spring.service.catalog.dto.ProductResource;
import dev.trials.spring.service.catalog.model.Product;
import dev.trials.spring.service.catalog.service.ProductService;
import dev.trials.spring.service.catalog.web.ProductController;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {ProductController.class})
@ActiveProfiles("itest")
public class ProductControllerIntegrationTest {

    @MockBean
    ProductService mockedService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenProductResource_thenReturns200() throws Exception{

        ProductResource resource = ProductResource.builder().name("Wings of Fire")
                                    .type("Shippable").category("Book").unitPrice(200f).build();
        String postBody=objectMapper.writeValueAsString(resource);

        Product iProduct = ProductController.toEntity(resource);

        when(mockedService.addNewProduct(iProduct)).thenReturn(iProduct);
        
        MvcResult result=mockMvc.perform(post("/catalog/product/").content(postBody).contentType("application/json").accept("application/json"))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

        String responseBody=result.getResponse().getContentAsString();
        Product oProduct=objectMapper.readerFor(Product.class).readValue(responseBody);
        assertThat(oProduct.getName()).isEqualTo(resource.getName());
        assertThat(oProduct.getType().getName()).isEqualTo(resource.getType());
        assertThat(oProduct.getCategory().getName()).isEqualTo(resource.getCategory());
        
    }

}