package com.cineflow.bug.entity;
import jakarta.persistence.*;
import lombok.Getter; import lombok.Setter;
@Entity @Table(name="priorities") @Getter @Setter public class Priority extends LookupEntity { @Column(nullable=false) private int sortOrder; }
