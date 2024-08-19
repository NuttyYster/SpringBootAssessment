package com.eviro365.assessment.grad001.nuttymokgapa.UnitTests;

import com.eviro365.assessment.grad001.nuttymokgapa.repository.RecyclingTipsRepository;
import com.eviro365.assessment.grad001.nuttymokgapa.service.RecyclingTipsService;
import com.eviro365.assessment.grad001.nuttymokgapa.model.RecyclingTips;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RecyclingTipsServiceTests {

    @InjectMocks
    private RecyclingTipsService service;

    @Mock
    private RecyclingTipsRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTipsTest() {
        List<RecyclingTips> tips = Arrays.asList(
                new RecyclingTips(1L, "clean","remove any unwanted material from the glass"),
                new RecyclingTips(2L, "sort","sort them according to the density")
        );
        when(repository.findAll()).thenReturn(tips);

        List<RecyclingTips> result = service.getAllTips();
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void getTipsByIdTest() {
        RecyclingTips tips = new RecyclingTips(1L, "pack", "pack them according to heir hardness");
        when(repository.findById(1L)).thenReturn(Optional.of(tips));

        RecyclingTips result = service.getTipById(1L);
        assertEquals("pack", result.getName());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void saveTipsTest() {
        RecyclingTips tips = new RecyclingTips(1L, "group", "rearrange them according to their colours");
        when(repository.save(tips)).thenReturn(tips);

        RecyclingTips result = service.saveTip(tips);
        assertEquals("group", result.getName());
        verify(repository, times(1)).save(tips);
    }

    @Test
    public void deleteTips() {
        service.deleteTip(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
