package com.eviro365.assessment.grad001.nuttymokgapa;

import com.eviro365.assessment.grad001.nuttymokgapa.service.WasteCategoryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.eviro365.assessment.grad001.nuttymokgapa.model.WasteCategory;
import com.eviro365.assessment.grad001.nuttymokgapa.repository.WasteCategotyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void getCategoryByIdTest() {
        WasteCategory category = new WasteCategory(1L, "Plastic", "Plastic waste");
        when(repository.findById(1L)).thenReturn(Optional.of(category));

        WasteCategory result = service.getCategoryById(1L);

        assertEquals("Plastic", result.getName());
        verify(repository, times(1)).findById(1L);

    }

    @Test
    public void saveCategoryTest() {
        WasteCategory category = new WasteCategory(1L, "Plastic", "Plastic waste");
        when(repository.save(category)).thenReturn(category);

        WasteCategory result = service.saveCategory(category);

        assertEquals("Plastic", result.getName());
        verify(repository, times(1)).save(category);
    }

}
