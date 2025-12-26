// // package com.example.demo.service;

// // import com.example.demo.model.ApprovalRequest;
// // import java.util.List;

// // public interface ApprovalRequestService {

// //     ApprovalRequest createRequest(ApprovalRequest request);

// //     List<ApprovalRequest> getAllRequests();

// //     List<ApprovalRequest> getRequestsByRequester(Long requesterId);
// // }



// package com.example.demo.service;

// import com.example.demo.model.ApprovalRequest;

// import java.util.List;

// public interface ApprovalRequestService {

//     ApprovalRequest createRequest(ApprovalRequest request);

//     List<ApprovalRequest> getRequestsByRequester(Long requesterId);

//     List<ApprovalRequest> getAllRequests();
// }


package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalRequestService {
    
    @Autowired
    private ApprovalRequestRepository requestRepository;
    
    public ApprovalRequest createRequest(ApprovalRequest request) {
        if (request.getStatus() == null) {
            request.setStatus("PENDING");
        }
        return requestRepository.save(request);
    }
    
    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        return requestRepository.findByRequesterId(requesterId);
    }
    
    public List<ApprovalRequest> getAllRequests() {
        return requestRepository.findAll();
    }
}
