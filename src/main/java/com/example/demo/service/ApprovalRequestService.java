package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ApprovalRequest;

public interface ApprovalRequestService {

    ApprovalRequest createRequest(ApprovalRequest request);

    List<ApprovalRequest> getAllRequests();

    List<ApprovalRequest> getRequestsByRequester(Long requesterId);
}
