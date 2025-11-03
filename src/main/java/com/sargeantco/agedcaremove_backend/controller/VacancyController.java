package com.sargeantco.agedcaremove_backend.controller;

import com.sargeantco.agedcaremove_backend.model.VacancyQuery;
import com.sargeantco.agedcaremove_backend.repo.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyRepository vacancyRepository;

    @PostMapping
    public ResponseEntity<VacancyQuery> create(@RequestBody VacancyQuery body) {
        VacancyQuery saved = vacancyRepository.save(body);
        return ResponseEntity.created(URI.create("/api/vacancies/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<VacancyQuery> list() {
        return vacancyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacancyQuery> get(@PathVariable Long id) {
        return vacancyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
