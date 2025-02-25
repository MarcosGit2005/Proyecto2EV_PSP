package com.example.proyecto2ev_psp.model;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class TimeStampedPersistableObject {

    @Column(name="insert_ts",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTimeStamp;

    @Column(name="update_ts",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimeStamp;

    @PrePersist
    public void onInsert() {
        this.insertTimeStamp = new Date();
        this.updateTimeStamp = insertTimeStamp;
    }
    @PreUpdate
    public void onUpdate() {
        this.updateTimeStamp = new Date();
    }

}
