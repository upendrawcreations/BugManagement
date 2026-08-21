package com.cineflow.bug.entity;
import jakarta.persistence.*; import lombok.Getter; import lombok.Setter;
@Entity @Table(name="bug_frames") @Getter @Setter public class BugFrame extends BaseEntity {
  @Column(name="bug_id", nullable=false) private java.util.UUID bugId;
  private Long frameNumber; @Column(length=50) private String timecode;
  @ManyToOne(fetch=FetchType.LAZY, optional=false) @JoinColumn(name="frame_type_id") private FrameType frameType;
  private Long startFrame; private Long endFrame;
}
