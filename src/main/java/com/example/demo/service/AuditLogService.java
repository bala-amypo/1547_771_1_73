package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;
import java.util.List;

public interface AuditLogService {

    AuditLogRecord log(Long requestId, String eventType, String details);

    List<AuditLogRecord> getByRequestId(Long requestId);
}
