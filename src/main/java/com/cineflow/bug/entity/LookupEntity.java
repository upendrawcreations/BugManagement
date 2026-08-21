package com.cineflow.bug.entity;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass @EntityListeners(AuditingEntityListener.class) @Getter @Setter
public abstract class LookupEntity {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(nullable=false, unique=true, length=50) private String code;
  @Column(nullable=false, unique=true, length=100) private String name;
  @Column(length=500) private String description;
  @Column(nullable=false) private boolean active = true;
  @CreatedDate @Column(nullable=false, updatable=false) private Instant createdAt;
}
