package com.eviro365.assessment.grad001.nuttymokgapa.UnitTests;

import com.eviro365.assessment.grad001.nuttymokgapa.repository.DisposalGuidelineRepository;
import com.eviro365.assessment.grad001.nuttymokgapa.service.DisposalGuidelineService;
import com.eviro365.assessment.grad001.nuttymokgapa.model.DisposalGuidelines;

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

public class DisposalGuidelinesServiceTests {

    @InjectMocks
    private DisposalGuidelineService service;

    @Mock
    private DisposalGuidelineRepository repository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllGuidelinesTest() {
        List<DisposalGuidelines> guidelines = Arrays.asList(
                new DisposalGuidelines(1L, "Dispose into the paper bin section", "PPR"),
                new DisposalGuidelines(2L, "Dispose into the glass bin section", "GLS")
        );
        when(repository.findAll()).thenReturn(guidelines);

        List<DisposalGuidelines> results = service.getAllGuidelines();
        assertEquals(2, results.size());
        verify(repository, times(1)).findAll();
    }
}
