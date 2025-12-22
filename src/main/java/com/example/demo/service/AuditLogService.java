package com.example.demo.service;

import com.example.demo.entity.AuditLogRecord;

import java.util.List;

public interface AuditLogService {

    AuditLogRecord save(AuditLogRecord record);

    List<AuditLogRecord> getLogsByRequestId(Long requestId);
}
