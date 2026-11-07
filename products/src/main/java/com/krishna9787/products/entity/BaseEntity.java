package com.krishna9787.products.entity;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
@Hidden
public class BaseEntity {

    @Column(updatable = false)
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(updatable = false)
    @LastModifiedBy
    private String updatededBy;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(updatable = false)
    @CreatedBy
    private String createdBy;
}
