package com.cineflow.bug.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass @EntityListeners(AuditingEntityListener.class) @Getter @Setter
public abstract class BaseEntity {
  @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID id;
  @CreatedDate @Column(nullable=false, updatable=false) private Instant createdAt;
  @LastModifiedDate private Instant updatedAt;
  @CreatedBy @Column(updatable=false) private UUID createdBy;
  @LastModifiedBy private UUID updatedBy;
  @Version private Long version;
}
