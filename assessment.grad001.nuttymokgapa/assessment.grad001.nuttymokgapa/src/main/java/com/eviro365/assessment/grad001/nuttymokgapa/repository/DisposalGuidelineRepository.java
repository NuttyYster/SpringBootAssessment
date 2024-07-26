package com.eviro365.assessment.grad001.nuttymokgapa.repository;

import com.eviro365.assessment.grad001.nuttymokgapa.model.DisposalGuidelines;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This class extends the JpaRepository, where all the classes are defined for us already
 * */

@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuidelines, Long> {
}
