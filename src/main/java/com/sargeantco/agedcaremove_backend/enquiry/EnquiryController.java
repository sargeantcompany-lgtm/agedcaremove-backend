package com.sargeantco.agedcaremove_backend.enquiry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.sargeantco.agedcaremove_backend.service.EmailService;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://sargeantandco.com",
        "https://www.sargeantandco.com"
})

public class EnquiryController {

    private final EnquiryRepository enquiryRepository;
    private final EmailService emailService;

    public EnquiryController(EnquiryRepository enquiryRepository, EmailService emailService) {
        this.enquiryRepository = enquiryRepository;
        this.emailService = emailService;
    }

    // === FRONTEND USES THIS ONE ===
    @PostMapping
    public ResponseEntity<Enquiry> createEnquiry(@RequestBody Enquiry enquiry) {
        Enquiry saved = enquiryRepository.save(enquiry);

        // === SEND EMAILS ===
        try {
            String teamBody = """
                NEW ENQUIRY RECEIVED
                --------------------
                Name: %s
                Phone: %s
                Email: %s
                Care For: %s
                Stage: %s
                Timeline: %s

                Notes:
                %s
                """.formatted(
                    orDash(saved.getFullName()),
                    orDash(saved.getPhone()),
                    orDash(saved.getEmail()),
                    orDash(saved.getCareFor()),
                    orDash(saved.getStage()),
                    orDash(saved.getTimeline()),
                    orDash(saved.getNotes())
            );

            emailService.sendNewEnquiryToTeam(
                    "New enquiry — " + orDash(saved.getFullName()), teamBody
            );

            emailService.sendCopyToEnquirer(
                    saved.getEmail(),
                    "Hi " + orDash(saved.getFullName()) +
                            ",\n\nThanks for reaching out. We received your enquiry and will call you shortly.\n\n— Aslam, Sargeant & Co — Aged-Care Move"
            );
        } catch (Exception e) {
            System.err.println("⚠️ Email sending failed: " + e.getMessage());
        }
        // === END EMAILS ===

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // === ADMIN USES THIS ONE ===
    @GetMapping
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        return ResponseEntity.ok(enquiryRepository.findAll());
    }

    private static String orDash(String s) {
        return (s == null || s.isBlank()) ? "—" : s;
    }
}
