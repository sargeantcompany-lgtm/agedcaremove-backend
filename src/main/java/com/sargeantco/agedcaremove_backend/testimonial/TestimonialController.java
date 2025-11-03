package com.sargeantco.agedcaremove_backend.testimonial;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
@CrossOrigin(origins = "http://localhost:5173") // allow Vite dev server
public class TestimonialController {

    private final TestimonialRepo repo;

    public TestimonialController(TestimonialRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Testimonial> all() {
        return repo.findAll();
    }

    @PostMapping
    public Testimonial create(@RequestBody Testimonial t) {
        return repo.save(t);
    }
}
