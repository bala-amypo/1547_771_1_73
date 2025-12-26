package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.service.ApprovalActionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    @Autowired
    private ApprovalActionRepository approvalActionRepository;

    @Override
    public ApprovalAction saveAction(ApprovalAction action) {
        return approvalActionRepository.save(action);
    }

    @Override
    public List<ApprovalAction> getActionsByLevelAndAction(Integer level, String action) {
        return approvalActionRepository.findByLevelAndAction(level, action);
    }

    @Override
    public List<ApprovalAction> getAllActions() {
        return approvalActionRepository.findAll();
    }
}
