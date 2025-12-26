// package com.example.demo.service.impl;

// import com.example.demo.model.AuditLogRecord;
// import com.example.demo.repository.AuditLogRecordRepository;
// import com.example.demo.service.AuditLogService;
// import org.springframework.stereotype.Service;

// @Service
// public class AuditLogServiceImpl implements AuditLogService {

//     private final AuditLogRecordRepository repository;

//     public AuditLogServiceImpl(AuditLogRecordRepository repository) {
//         this.repository = repository;
//     }

//     public AuditLogRecord saveLog(AuditLogRecord log) {
//         return repository.save(log);
//     }
// }


package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl
        implements AuditLogService {

    @Autowired
    private AuditLogRecordRepository repo;

    @Override
    public AuditLogRecord save(AuditLogRecord record) {
        return repo.save(record);
    }
}
