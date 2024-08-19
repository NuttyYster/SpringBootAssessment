package com.eviro365.assessment.grad001.nuttymokgapa.IntegrationTests;

import com.eviro365.assessment.grad001.nuttymokgapa.model.RecyclingTips;
import com.eviro365.assessment.grad001.nuttymokgapa.repository.RecyclingTipsRepository;
import com.eviro365.assessment.grad001.nuttymokgapa.service.RecyclingTipsService;
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


}
