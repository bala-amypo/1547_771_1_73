package com.example.demo.repository;

import com.example.demo.entity.ApprovalAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalActionRepository
        extends JpaRepository<ApprovalAction, Long> {
}
