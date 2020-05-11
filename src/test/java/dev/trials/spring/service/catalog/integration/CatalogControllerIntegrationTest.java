package dev.trials.spring.service.catalog.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import dev.trials.spring.service.catalog.web.CatalogController;


@WebMvcTest(CatalogController.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("itest")
public class CatalogControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void indexReturnApiInfo() throws Exception{
        String content = "{\"version\":\"0.1.TEST\",\"description\":\"TEST\"}";
        mockMvc.perform(get("/catalog/api/meta").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json(content));
    }
}