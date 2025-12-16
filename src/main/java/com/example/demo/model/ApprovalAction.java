package com.example.demo.model;

import java.time.LocalDateTime;

public class ApprovalAction {
    private long id;
    private long requestid;
    private long approverid;
    private int levelNumber;
    private String action;
    private String comments;
    private LocalDateTime actionDate;

    public  ApprovalAction(){

    }

    public ApprovalAction(long id, long requestid, long approverid, int levelNumber, String action, String comments,
            LocalDateTime actionDate) {
        this.id = id;
        this.requestid = requestid;
        this.approverid = approverid;
        this.levelNumber = levelNumber;
        this.action = action;
        this.comments = comments;
        this.actionDate = actionDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public long getApproverid() {
        return approverid;
    }

    public void setApproverid(long approverid) {
        this.approverid = approverid;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }

    
}
