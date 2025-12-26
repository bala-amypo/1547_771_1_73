package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;

import java.util.List;

public interface ApprovalRequestService {

    ApprovalRequest createRequest(ApprovalRequest request);

    ApprovalRequest getRequestById(Long id);

    List<ApprovalRequest> getRequestsByRequester(Long requesterId);

    ApprovalRequest updateRequestStatus(Long requestId, String status);

    List<ApprovalRequest> getAllRequests();


    ApprovalRequest getById(Long id);
    void deleteRequest(Long id);
}

}
