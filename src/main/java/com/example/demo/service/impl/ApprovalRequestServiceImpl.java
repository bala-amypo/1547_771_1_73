package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    @Autowired
    private ApprovalRequestRepository approvalRequestRepository;

    @Override
    public ApprovalRequest createRequest(ApprovalRequest request) {
        return approvalRequestRepository.save(request);
    }

    @Override
    public ApprovalRequest getRequestById(Long id) {
        return approvalRequestRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ApprovalRequest not found with id: " + id));
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        return approvalRequestRepository.findByRequesterId(requesterId);
    }

    @Override
    public ApprovalRequest updateRequestStatus(Long requestId, String status) {
        ApprovalRequest request = getRequestById(requestId);
        request.setStatus(status);
        return approvalRequestRepository.save(request);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return approvalRequestRepository.findAll();
    }

    @Override
public void deleteRequest(Long id) {
    approvalRequestRepository.deleteById(id);
}

}
