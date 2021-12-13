package com.thaiitwork.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.thaiitwork.util.Status;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
public class BaseModel {
   /*
    // https://stackoverflow.com/questions/42366763/hibernate-creationtimestamp-updatetimestamp-for-calendar
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date created;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    protected Date updated;
    
    @NotNull
    //@OneToOne
    //protected User createdBy;
    protected Integer createdBy;
    
    @NotNull
    //@OneToOne
    //protected User updatedBy;
    protected Integer updatedBy;
    
    @NotNull
    protected Status status;*/

}
