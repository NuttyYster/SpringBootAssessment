package com.eviro365.assessment.grad001.nuttymokgapa.repository;

import com.eviro365.assessment.grad001.nuttymokgapa.model.WasteCategory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This class extends the JpaRepository, where all the classes are defined for us already
 * */

@Repository
public interface WasteCategotyRepository extends JpaRepository<WasteCategory, Long> {
}
