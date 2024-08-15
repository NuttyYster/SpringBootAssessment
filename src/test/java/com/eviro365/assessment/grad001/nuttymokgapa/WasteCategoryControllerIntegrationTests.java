package com.eviro365.assessment.grad001.nuttymokgapa;

import com.eviro365.assessment.grad001.nuttymokgapa.repository.WasteCategotyRepository;
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
//
//    @Test
//    public void getCategoryByIdTest() throws Exception {
//        WasteCategory category = repository.findAll().get(0);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/waste-category/{id}", category.getId())
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("Paper")));
//    }
}
