package com.eviro365.assessment.grad001.nuttymokgapa.IntegrationTests;

import com.eviro365.assessment.grad001.nuttymokgapa.repository.WasteCategotyRepository;
import com.eviro365.assessment.grad001.nuttymokgapa.service.WasteCategoryService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.eviro365.assessment.grad001.nuttymokgapa.model.WasteCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class WasteCategoryControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WasteCategotyRepository repository;

    @Autowired
    private WasteCategoryService service;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
        repository.save(new WasteCategory(1L, "Paper", "Paper waste"));
        repository.save(new WasteCategory(2L, "Glass", "Glass waste"));
    }

    @Test
    public void getAllCategoriesTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/waste-category")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Paper")))
                .andExpect(jsonPath("$[1].name", is("Glass")));
    }

    @Test
    public void getCategoryByIdTest() throws Exception {

        WasteCategory category = repository.findAll().get(0);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/waste-category/{id}", category.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Paper")));

    }

    @Test
    public void createCategoryTest() throws Exception {
        String newCategory = "{\"name\": \"Glass\", \"description\": \"Glass waste\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/waste-category")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newCategory))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Glass")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/waste-category")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

    }

    @Test
    public void updateCategoryTest() throws Exception {
        WasteCategory category = repository.findAll().get(0);
        String updatedCategory = "{\"name\": \"Updated Paper\", \"description\":\"Updated description\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/waste-category/{id}", category.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedCategory))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("Updated Paper")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/waste-category/{id}", category.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Updated Paper")));
    }

    @Test
    public void deleteCategoryTest() throws Exception {
        WasteCategory category = repository.findAll().get(0);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/waste-category/{id}", category.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/waste-category")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }
}
