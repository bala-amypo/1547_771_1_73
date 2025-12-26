// package com.example.demo.repository;

// import com.example.demo.model.ApprovalAction;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface ApprovalActionRepository
//         extends JpaRepository<ApprovalAction, Long> {

//     List<ApprovalAction> findByLevelNumberAndAction(Integer levelNumber, String action);

//     // 🔥 REQUIRED FOR TESTS
//     List<ApprovalAction> findByLevelAndAction(Integer level, String action);
// }



package com.example.demo.repository;

import com.example.demo.model.ApprovalAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApprovalActionRepository
        extends JpaRepository<ApprovalAction, Long> {

    @Query("SELECT a FROM ApprovalAction a WHERE a.levelNumber = :level AND a.action = :action")
    List<ApprovalAction> findByLevelAndAction(Integer level, String action);
}
