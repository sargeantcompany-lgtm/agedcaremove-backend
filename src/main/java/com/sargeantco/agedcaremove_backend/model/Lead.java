package com.sargeantco.agedcaremove_backend.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.Instant;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Lead {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String fullName;
    @Column(nullable = false) private String phone;
    @Column(nullable = false) private String email;

    private String suburb;
    private String timeline;

    @Column(length = 4000)
    private String notes;

    @CreationTimestamp
    private Instant createdAt;
}
