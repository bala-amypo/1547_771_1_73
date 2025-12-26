package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;

import java.util.List;

public interface AuditLogService {

    AuditLogRecord saveLog(AuditLogRecord logRecord);

    List<AuditLogRecord> getLogsByRequestId(Long requestId);

    List<AuditLogRecord> getAllLogs();
}
