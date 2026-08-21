package com.cineflow.bug.entity;
import jakarta.persistence.*; import lombok.Getter; import lombok.Setter;
@Entity @Table(name="bug_references") @Getter @Setter public class BugReference extends BaseEntity {
  @Column(name="bug_id", nullable=false) private java.util.UUID bugId;
  @Column(nullable=false, length=500) private String fileName;
  @Column(nullable=false, length=1000) private String filePath;
  @Column(length=1000) private String fileUrl;
  private Long fileSize; @Column(length=255) private String mimeType;
}
