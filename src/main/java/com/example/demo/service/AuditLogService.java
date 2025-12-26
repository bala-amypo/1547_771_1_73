package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;

public interface AuditLogService {
    void logEvent(Long requestId, String eventType, String details);
}