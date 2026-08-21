package com.cineflow.bug.entity;
import jakarta.persistence.*;
import lombok.Getter; import lombok.Setter;
@Entity @Table(name="severities") @Getter @Setter public class Severity extends LookupEntity { @Column(nullable=false) private int sortOrder; }
