package com.eviro365.assessment.grad001.nuttymokgapa;

import com.eviro365.assessment.grad001.nuttymokgapa.service.WasteCategoryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.eviro365.assessment.grad001.nuttymokgapa.model.WasteCategory;
import com.eviro365.assessment.grad001.nuttymokgapa.repository.WasteCategotyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class WasteCategoryServiceTests {

    @InjectMocks
    private WasteCategoryService service;

    @Mock
    private WasteCategotyRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllCategoriesTest() {
        List<WasteCategory> categories = Arrays.asList(
                new WasteCategory(1L, "Plastic", "Plastic waste"),
                new WasteCategory(2L, "Paper", "Paper waste")
        );
        when(repository.findAll()).thenReturn(categories);

        List<WasteCategory> result = service.getAllCategories();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }
}
