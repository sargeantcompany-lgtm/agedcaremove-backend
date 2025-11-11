package com.sargeantco.agedcaremove_backend.enquiry;

import com.sargeantco.agedcaremove_backend.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/enquiries")
public class EnquiryController {

    private final EmailService emailService;

    public EnquiryController(EmailService emailService) {
        this.emailService = emailService;
    }

    // Minimal request DTO (matches your frontend fields)
    public record EnquiryRequest(
            String fullName,
            String phone,
            String email,
            String suburb,
            String timeline,
            String notes,
            String source
    ) {}

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EnquiryRequest req) {
        String subject = "New website enquiry: " + (req.fullName() == null ? "(no name)" : req.fullName());
        String body = """
                New enquiry received %s

                Name: %s
                Phone: %s
                Email: %s
                Suburb: %s
                Timeline: %s
                Source: %s

                Notes:
                %s
                """.formatted(
                OffsetDateTime.now(),
                req.fullName(), req.phone(), req.email(),
                req.suburb(), req.timeline(), req.source(),
                req.notes()
        );

        emailService.sendNewEnquiryToTeam(subject, body);
        return ResponseEntity.ok(Map.of("status", "sent"));
    }

    // Fingerprint so we can confirm the right build is running in Render
    @GetMapping("/_whoami")
    public Map<String, String> whoami() {
        return Map.of("build", "email-only-2025-11-11");
    }
}
