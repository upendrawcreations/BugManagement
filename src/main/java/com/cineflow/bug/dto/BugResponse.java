package com.cineflow.bug.dto;
import java.time.*; import java.util.UUID;
public record BugResponse(UUID id, UUID versionId, String bugKey, String title, String description, LookupResponse department, LookupResponse priority, LookupResponse severity, LookupResponse status, String tags, String notes, String reviewerComment, LocalDate dueDate, Instant createdAt, Instant updatedAt, Long version) {}
