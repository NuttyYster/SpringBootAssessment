package com.eviro365.assessment.grad001.nuttymokgapa.repository;

import com.eviro365.assessment.grad001.nuttymokgapa.model.RecyclingTips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipsRepository extends JpaRepository<RecyclingTips, Long> {
/**
 * This class extends the JpaRepository, where all the classes are defined for us already
 * */
}
