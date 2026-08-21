package com.cineflow.bug.entity;
import jakarta.persistence.*;
import lombok.Getter; import lombok.Setter;
@Entity @Table(name="bug_statuses") @Getter @Setter public class BugStatus extends LookupEntity { @Column(nullable=false) private int sortOrder; }
