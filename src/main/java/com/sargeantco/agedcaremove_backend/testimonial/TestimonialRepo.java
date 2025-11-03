package com.sargeantco.agedcaremove_backend.testimonial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepo extends JpaRepository<Testimonial, Long> {
}
