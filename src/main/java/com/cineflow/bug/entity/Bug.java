package com.cineflow.bug.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter; import lombok.Setter;

@Entity @Table(name="bugs", indexes={@Index(name="idx_bugs_version_id", columnList="version_id"), @Index(name="idx_bugs_status_id", columnList="status_id")}) @Getter @Setter
public class Bug extends BaseEntity {
  @Column(name="version_id", nullable=false) private UUID versionId;
  @Column(name="bug_key", nullable=false, unique=true, length=100) private String bugKey;
  @Column(nullable=false) private String title;
  @Column(columnDefinition="LONGTEXT") private String description;
  @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="department_id") private Department department;
  @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="priority_id") private Priority priority;
  @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="severity_id") private Severity severity;
  @ManyToOne(fetch=FetchType.LAZY, optional=false) @JoinColumn(name="status_id", nullable=false) private BugStatus status;
  @Column(columnDefinition="LONGTEXT") private String tags;
  @Column(columnDefinition="LONGTEXT") private String notes;
  @Column(columnDefinition="LONGTEXT") private String reviewerComment;
  private LocalDate dueDate;
  @Column(nullable=false) private boolean deleted;
  private java.time.Instant deletedAt;
}
