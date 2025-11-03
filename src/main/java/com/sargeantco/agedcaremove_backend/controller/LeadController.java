package com.sargeantco.agedcaremove_backend.controller;

import com.sargeantco.agedcaremove_backend.model.Lead;
import com.sargeantco.agedcaremove_backend.repo.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/leads")
@RequiredArgsConstructor
public class LeadController {
    private final LeadRepository leadRepository;

    @PostMapping
    public ResponseEntity<Lead> create(@RequestBody Lead body) {
        Lead saved = leadRepository.save(body);
        return ResponseEntity.created(URI.create("/api/leads/" + saved.getId())).body(saved);
    }

    @GetMapping
    public List<Lead> list() {
        return leadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> get(@PathVariable Long id) {
        return leadRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
