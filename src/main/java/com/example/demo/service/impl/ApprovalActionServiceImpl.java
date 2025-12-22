package com.example.demo.service.impl;

import com.example.demo.entity.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.stereotype.Service;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository approvalActionRepository;
    private final ApprovalRequestRepository approvalRequestRepository;

    public ApprovalActionServiceImpl(
            ApprovalActionRepository approvalActionRepository,
            ApprovalRequestRepository approvalRequestRepository) {

        this.approvalActionRepository = approvalActionRepository;
        this.approvalRequestRepository = approvalRequestRepository;
    }

    @Override
    public ApprovalAction recordAction(ApprovalAction action) {
        return approvalActionRepository.save(action);
    }
}
