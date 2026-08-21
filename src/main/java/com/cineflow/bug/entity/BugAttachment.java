package com.cineflow.bug.entity;
import jakarta.persistence.*; import java.math.BigDecimal; import lombok.Getter; import lombok.Setter;
@Entity @Table(name="bug_attachments") @Getter @Setter public class BugAttachment extends BaseEntity {
  @Column(name="bug_id", nullable=false) private java.util.UUID bugId;
  @ManyToOne(fetch=FetchType.LAZY, optional=false) @JoinColumn(name="attachment_type_id") private AttachmentType attachmentType;
  @Column(nullable=false, length=500) private String fileName;
  @Column(nullable=false, length=1000) private String filePath;
  @Column(length=1000) private String fileUrl;
  @Column(length=255) private String mimeType; private Long fileSize;
  @Column(precision=12, scale=3) private BigDecimal duration;
}
