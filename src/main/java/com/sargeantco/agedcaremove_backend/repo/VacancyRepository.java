package com.sargeantco.agedcaremove_backend.repo;

import com.sargeantco.agedcaremove_backend.model.VacancyQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<VacancyQuery, Long> {}
