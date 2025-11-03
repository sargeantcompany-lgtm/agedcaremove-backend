package com.sargeantco.agedcaremove_backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.Instant;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class VacancyQuery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String areas;
    private String careLevel;
    private String budget;
    private String urgency;

    @Column(length = 4000)
    private String extras;

    private String fullName;
    private String phone;
    private String email;

    @CreationTimestamp
    private Instant createdAt;
}

