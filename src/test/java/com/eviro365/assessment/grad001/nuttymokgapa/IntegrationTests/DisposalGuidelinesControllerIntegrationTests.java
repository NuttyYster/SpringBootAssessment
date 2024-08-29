package com.eviro365.assessment.grad001.nuttymokgapa.IntegrationTests;

import com.eviro365.assessment.grad001.nuttymokgapa.repository.DisposalGuidelineRepository;
import com.eviro365.assessment.grad001.nuttymokgapa.service.DisposalGuidelineService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import com.eviro365.assessment.grad001.nuttymokgapa.model.DisposalGuidelines;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DisposalGuidelinesControllerIntegrationTests {

    @Autowired
    private DisposalGuidelineService service;

    @Autowired
    private DisposalGuidelineRepository repository;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
        repository.save(new DisposalGuidelines(1L, "Glass", "GLS"));
        repository.save(new DisposalGuidelines(2L, "Plastic", "PLS"));
    }

    @Test
    public void getAllGuidelinesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/disposal-guidelines")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].guideline", is("Glass")))
                .andExpect(jsonPath("$[1].guideline", is("Plastic")));
    }

    @Test
    public void getGuidelineByIdTest() throws Exception {
        DisposalGuidelines guidelines = repository.findAll().get(0);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/disposal-guidelines/{id}", guidelines.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.guideline", is("Glass")));
    }

    @Test
    public void createGuidelineTest() throws Exception {
        String newGuideline = "{\"guideline\":\"Paper\",\"categoryId\": \"PPR\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/disposal-guidelines")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newGuideline))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guideline", is("Paper")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/disposal-guidelines")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void updateGuidelineTest() throws Exception {
        DisposalGuidelines guidelines = repository.findAll().get(0);
        String updatedGuideline = "{\"guideline\":\"Updated Paper\",\"categoryId\": \"PPR\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/disposal-guidelines/{id}", guidelines.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedGuideline))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guideline", is("Updated Paper")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/disposal-guidelines/{id}", guidelines.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guideline", is("Updated Paper")));
    }

    @Test
    public void deleteGuidelineTest() throws Exception {
        DisposalGuidelines guidelines = repository.findAll().get(0);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/disposal-guidelines/{id}", guidelines.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/disposal-guidelines")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
