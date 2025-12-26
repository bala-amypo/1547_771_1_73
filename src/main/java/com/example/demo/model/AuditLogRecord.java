package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_log_records")
@Data
public class AuditLogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;
    private String eventType;
    private String details;
    
    private LocalDateTime loggedAt = LocalDateTime.now();
}