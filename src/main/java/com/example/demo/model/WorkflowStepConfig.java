// // package com.example.demo.model;

// // import jakarta.persistence.*;

// // @Entity
// // @Table(name = "workflow_step_configs")
// // public class WorkflowStepConfig {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     private Long templateId;
// //     private Integer levelNumber;
// //     private String approverRole;
// //     private Boolean isFinalStep;
// //     private String instructions;

// //     public WorkflowStepConfig() {}

// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }

// //     public Long getTemplateId() { return templateId; }
// //     public void setTemplateId(Long templateId) { this.templateId = templateId; }

// //     public Integer getLevelNumber() { return levelNumber; }
// //     public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }

// //     public String getApproverRole() { return approverRole; }
// //     public void setApproverRole(String approverRole) { this.approverRole = approverRole; }

// //     public Boolean getIsFinalStep() { return isFinalStep; }
// //     public void setIsFinalStep(Boolean isFinalStep) { this.isFinalStep = isFinalStep; }

// //     public String getInstructions() { return instructions; }
// //     public void setInstructions(String instructions) { this.instructions = instructions; }
// // }




// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "workflow_steps")
// public class WorkflowStepConfig {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long templateId;
//     private Integer levelNumber;
//     private String approverRole;
//     private String instructions;

//     public Long getId() { return id; }
//     public Long getTemplateId() { return templateId; }
//     public Integer getLevelNumber() { return levelNumber; }
//     public String getApproverRole() { return approverRole; }
//     public String getInstructions() { return instructions; }

//     public void setId(Long id) { this.id = id; }
//     public void setTemplateId(Long templateId) { this.templateId = templateId; }
//     public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }
//     public void setApproverRole(String approverRole) { this.approverRole = approverRole; }
//     public void setInstructions(String instructions) { this.instructions = instructions; }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "workflow_step_configs")
public class WorkflowStepConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "template_id", nullable = false)
    private Long templateId;
    
    @Column(name = "level_number", nullable = false)
    private Integer levelNumber;
    
    @Column(name = "approver_role", nullable = false)
    private String approverRole;
    
    private String instructions;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }
    public Integer getLevelNumber() { return levelNumber; }
    public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }
    public String getApproverRole() { return approverRole; }
    public void setApproverRole(String approverRole) { this.approverRole = approverRole; }
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkflowStepConfig that = (WorkflowStepConfig) o;
        return Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
