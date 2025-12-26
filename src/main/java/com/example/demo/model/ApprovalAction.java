// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import java.time.LocalDateTime;

// // @Entity
// // @Table(name = "approval_actions")
// // public class ApprovalAction {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private Long requestId;
// //     private Long approverId;
// //     private Integer levelNumber;
// //     private String action; // APPROVED / REJECTED
// //     private String comments;
// //     private LocalDateTime actionDate = LocalDateTime.now();

// //     public ApprovalAction() {}

// //     public Long getId() {
// //         return id;
// //     }

// //     public Long getRequestId() {
// //         return requestId;
// //     }

// //     public void setRequestId(Long requestId) {
// //         this.requestId = requestId;
// //     }

// //     public Long getApproverId() {
// //         return approverId;
// //     }

// //     public void setApproverId(Long approverId) {
// //         this.approverId = approverId;
// //     }

// //     public Integer getLevelNumber() {
// //         return levelNumber;
// //     }

// //     public void setLevelNumber(Integer levelNumber) {
// //         this.levelNumber = levelNumber;
// //     }

// //     public String getAction() {
// //         return action;
// //     }

// //     public void setAction(String action) {
// //         this.action = action;
// //     }

// //     public String getComments() {
// //         return comments;
// //     }

// //     public void setComments(String comments) {
// //         this.comments = comments;
// //     }

// //     public LocalDateTime getActionDate() {
// //         return actionDate;
// //     }
// // }



// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "approval_actions")
// public class ApprovalAction {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long requestId;
//     private Long approverId;
//     private Integer levelNumber;
//     private String action;

//     private LocalDateTime actionDate = LocalDateTime.now();

//     public Long getId() { return id; }
//     public Long getRequestId() { return requestId; }
//     public Long getApproverId() { return approverId; }
//     public Integer getLevelNumber() { return levelNumber; }
//     public String getAction() { return action; }

//     public void setId(Long id) { this.id = id; }
//     public void setRequestId(Long requestId) { this.requestId = requestId; }
//     public void setApproverId(Long approverId) { this.approverId = approverId; }
//     public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }
//     public void setAction(String action) { this.action = action; }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "approval_actions")
public class ApprovalAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "request_id", nullable = false)
    private Long requestId;
    
    @Column(name = "approver_id", nullable = false)
    private Long approverId;
    
    @Column(name = "level_number", nullable = false)
    private Integer levelNumber;
    
    private String action;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public Long getApproverId() { return approverId; }
    public void setApproverId(Long approverId) { this.approverId = approverId; }
    public Integer getLevelNumber() { return levelNumber; }
    public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApprovalAction that = (ApprovalAction) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
