package com.eviro365.assessment.grad001.nuttymokgapa.IntegrationTests;

import com.eviro365.assessment.grad001.nuttymokgapa.model.RecyclingTips;
import com.eviro365.assessment.grad001.nuttymokgapa.repository.RecyclingTipsRepository;
import com.eviro365.assessment.grad001.nuttymokgapa.service.RecyclingTipsService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

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
public class RecyclingTipsControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RecyclingTipsRepository repository;

    @Autowired
    private RecyclingTipsService service;

    @BeforeEach
    public void setup() {
        repository.deleteAll();
        repository.save(new RecyclingTips(1L, "peel","remove all the extra coverings"));
        repository.save(new RecyclingTips(2L, "wipe", "clean the glass properly"));
    }

    @Test
    public void getAllTipsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recycling-tips")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("peel")))
                .andExpect(jsonPath("$[1].name", is("wipe")));
    }

    @Test
    public void getTipsByIdTest() throws Exception {

        RecyclingTips tips = repository.findAll().get(0);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/recycling-tips/{id}", tips.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("peel")));

    }

    @Test
    public void createTipsTest() throws Exception {
        String newTip = "{\"name\": \"Cut\", \"description\": \"remove all the colours on the bottle\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/recycling-tips")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newTip))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Cut")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/recycling-tips")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void updateTipsTest() throws Exception {
        RecyclingTips tips = repository.findAll().get(0);
        String updatedTip = "{\"name\": \"Updated Cut\", \"description\": \"Updated remove all the colours on the bottle\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/recycling-tips/{id}", tips.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedTip))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Updated Cut")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/recycling-tips/{id}", tips.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Updated Cut")));
    }

    @Test
    public void deleteTipTest() throws Exception {
        RecyclingTips tips = repository.findAll().get(0);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/recycling-tips/{id}", tips.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/recycling-tips")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
