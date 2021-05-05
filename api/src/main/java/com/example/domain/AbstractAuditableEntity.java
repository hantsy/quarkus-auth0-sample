package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity<ID> extends AbstractPersistableEntity<ID> implements Serializable {

    @CreationTimestamp
    @Column(name = "created_date")
    LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    LocalDateTime lastModifiedDate;

    @AttributeOverride(name = "username", column = @Column(name = "created_by"))
    @Embedded
    Username createdBy;

    @AttributeOverride(name = "username", column = @Column(name = "last_modified_by"))
    @Embedded
    Username lastModifiedBy;
}