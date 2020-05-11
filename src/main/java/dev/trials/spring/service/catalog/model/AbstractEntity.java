package dev.trials.spring.service.catalog.model;

import java.util.Date;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.data.domain.Persistable;

public abstract class AbstractEntity<ID> implements Persistable<ID> {

    @Transient
    private boolean isNew = true;
    
    @Temporal(TemporalType.TIMESTAMP) 
    private Date modifiedTime;

    @Version
    private Integer version;
  
    @Override
    public boolean isNew() {
      return isNew; 
    }
  
    @PrePersist 
    @PostLoad
    void markNotNew() {
      this.isNew = false;
    }

    @PrePersist
    void updateModifiedTime(){
        this.modifiedTime=new Date();
    }
  
  }