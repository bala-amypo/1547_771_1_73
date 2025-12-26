package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "approval_actions")
@Data
public class ApprovalAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Rule 2.4
    private Long id;

    private Long requestId;
    private Long approverId;
    private Integer levelNumber;
    
    private String action; // APPROVED / REJECTED
    private String comments;
    
    private LocalDateTime actionDate = LocalDateTime.now();
}