package com.example.domain;

import io.quarkus.security.identity.SecurityIdentity;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditingEntityListener {

    @PrePersist
    public void prePersist(AbstractAuditableEntity entity) {
        entity.setCreatedBy(currentUser());
    }

    @PreUpdate
    public void preUpdate(AbstractAuditableEntity entity) {
        entity.setLastModifiedBy(currentUser());
    }

    private Username currentUser() {
        var identity = CDI.current().select(SecurityIdentity.class).get();
        if (identity != null) {
            return new Username(identity.getPrincipal().getName());
        }
        return null;
    }
}
