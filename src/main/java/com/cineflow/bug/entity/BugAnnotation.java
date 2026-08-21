package com.cineflow.bug.entity;
import jakarta.persistence.*; import lombok.Getter; import lombok.Setter;
@Entity @Table(name="bug_annotations") @Getter @Setter public class BugAnnotation extends BaseEntity {
  @Column(name="bug_id", nullable=false) private java.util.UUID bugId;
  private Long frameNumber;
  @Column(nullable=false) private String annotationName;
  @ManyToOne(fetch=FetchType.LAZY, optional=false) @JoinColumn(name="annotation_type_id") private AnnotationType annotationType;
  private String reviewer;
  @Column(columnDefinition="json") private String annotationData;
  @Column(length=1000) private String imageUrl;
}
