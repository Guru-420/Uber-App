package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identity means auto increment
    @Column(nullable = false)
    protected Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this annotation tells SpringBoot about format of Date objects:DATE/TIME/TIMESTAMP.
    @CreatedDate       // this annotation tells SpringBoot only handle object Creation
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate // this annotation tells SpringBoot only handle object update
    protected Date updatedAt;
}
