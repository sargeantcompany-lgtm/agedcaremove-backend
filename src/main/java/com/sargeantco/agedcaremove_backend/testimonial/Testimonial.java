package com.sargeantco.agedcaremove_backend.testimonial;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String relation;

    @Column(length = 2000)
    private String text;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    // --- Getters/Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
