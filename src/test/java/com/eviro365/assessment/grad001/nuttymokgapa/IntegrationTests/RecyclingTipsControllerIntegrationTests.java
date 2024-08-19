package com.eviro365.assessment.grad001.nuttymokgapa.IntegrationTests;

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
}
