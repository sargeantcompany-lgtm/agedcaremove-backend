package com.sargeantco.agedcaremove_backend.repo;

import com.sargeantco.agedcaremove_backend.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {
    class VacancyRepository {
}
}
