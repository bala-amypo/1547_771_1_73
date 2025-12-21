package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log_records")
public class AuditLogRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;
    private String eventType;

    @Column(length = 1000)
    private String details;

    private LocalDateTime loggedAt;

   
    public AuditLogRecord() {
    }

    
    public AuditLogRecord(Long requestId, String eventType, String details) {
        this.requestId = requestId;
        this.eventType = eventType;
        this.details = details;
        this.loggedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public LocalDateTime getLoggedAt() { return loggedAt; }
}
