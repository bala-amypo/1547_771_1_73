package com.example.demo.repository;

import com.example.demo.model.ApprovalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest, Long> {
    // Required for filtering requests by requester in controllers and tests
    List<ApprovalRequest> findByRequesterId(Long requesterId);
}