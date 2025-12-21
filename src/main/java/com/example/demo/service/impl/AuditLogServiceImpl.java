package com.example.demo.Service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Service.AuditLogService;
import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRecordRepository repo;

    public AuditLogServiceImpl(AuditLogRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public AuditLogRecord log(Long requestId, String eventType, String details) {
        return repo.save(new AuditLogRecord(requestId, eventType, details));
    }

    @Override
    public List<AuditLogRecord> getByRequestId(Long requestId) {
        return repo.findByRequestId(requestId);
    }
}
