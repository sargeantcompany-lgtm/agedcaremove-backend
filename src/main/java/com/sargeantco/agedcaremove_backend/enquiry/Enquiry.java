package com.sargeantco.agedcaremove_backend.enquiry;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String phone;
    private String email;
    private String contactTime;
    private String contactMethod;

    private String careFor;
    private String stage;
    private String acat;
    private String location;

    @Column(length = 2000)
    private String concern;

    private String hasProperty;
    private String address;
    private String timeline;
    private String appraised;
    private String role;

    private String meetingType;
    private String availability;

    @Column(length = 2000)
    private String notes;

    private String spokenToOthers;
    private String missing;

    private Boolean consent;

    private OffsetDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = OffsetDateTime.now();
    }

    // getters and setters for all fields...

    public Long getId() { return id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContactTime() { return contactTime; }
    public void setContactTime(String contactTime) { this.contactTime = contactTime; }

    public String getContactMethod() { return contactMethod; }
    public void setContactMethod(String contactMethod) { this.contactMethod = contactMethod; }

    public String getCareFor() { return careFor; }
    public void setCareFor(String careFor) { this.careFor = careFor; }

    public String getStage() { return stage; }
    public void setStage(String stage) { this.stage = stage; }

    public String getAcat() { return acat; }
    public void setAcat(String acat) { this.acat = acat; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getConcern() { return concern; }
    public void setConcern(String concern) { this.concern = concern; }

    public String getHasProperty() { return hasProperty; }
    public void setHasProperty(String hasProperty) { this.hasProperty = hasProperty; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getTimeline() { return timeline; }
    public void setTimeline(String timeline) { this.timeline = timeline; }

    public String getAppraised() { return appraised; }
    public void setAppraised(String appraised) { this.appraised = appraised; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getMeetingType() { return meetingType; }
    public void setMeetingType(String meetingType) { this.meetingType = meetingType; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getSpokenToOthers() { return spokenToOthers; }
    public void setSpokenToOthers(String spokenToOthers) { this.spokenToOthers = spokenToOthers; }

    public String getMissing() { return missing; }
    public void setMissing(String missing) { this.missing = missing; }

    public Boolean getConsent() { return consent; }
    public void setConsent(Boolean consent) { this.consent = consent; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
