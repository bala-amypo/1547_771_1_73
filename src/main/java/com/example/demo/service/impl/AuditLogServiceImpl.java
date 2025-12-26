package com.example.demo.service.impl;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.AuditLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRecordRepository auditLogRecordRepository;

    @Override
    public AuditLogRecord saveLog(AuditLogRecord logRecord) {
        return auditLogRecordRepository.save(logRecord);
    }

    @Override
    public List<AuditLogRecord> getLogsByRequestId(Long requestId) {
        return auditLogRecordRepository.findByRequestId(requestId);
    }

    @Override
    public List<AuditLogRecord> getAllLogs() {
        return auditLogRecordRepository.findAll();
    }
}
