package com.example.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data()
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity
@Table(name = "posts")
public class Post extends AbstractAuditableEntity<Long> implements Serializable {

    @NotEmpty
    String title;

    @NotEmpty
    String content;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    Status status = Status.DRAFT;

    public static enum Status{
        DRAFT,
        PENDING_MODERATED,
        APPROVED,
        REJECTED
    }
}
