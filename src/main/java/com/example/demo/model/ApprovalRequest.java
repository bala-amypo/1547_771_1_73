package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "approval_requests")
@Data
public class ApprovalRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long templateId;
    private Long requesterId;
    private String requestTitle;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String requestPayloadJson;

    @Column(nullable = false)
    private String status = "PENDING"; // Default value per rules

    private Integer currentLevel;
    
    private LocalDateTime createdAt = LocalDateTime.now();
}