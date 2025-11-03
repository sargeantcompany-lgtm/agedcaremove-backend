package com.sargeantco.agedcaremove_backend.enquiry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = "http://localhost:5173")
public class EnquiryController {

    private final EnquiryRepository enquiryRepository;

    public EnquiryController(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    // FRONTEND USES THIS ONE:
    @PostMapping
    public ResponseEntity<Enquiry> createEnquiry(@RequestBody Enquiry enquiry) {
        Enquiry saved = enquiryRepository.save(enquiry);
        return ResponseEntity.ok(saved);
    }

    // THIS IS FOR YOU TO CHECK IF IT WORKED:
    @GetMapping
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        return ResponseEntity.ok(enquiryRepository.findAll());
    }
}
