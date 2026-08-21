package com.cineflow.bug.dto;
import jakarta.validation.constraints.*; import java.time.LocalDate; import java.util.UUID;
public record BugRequest(@NotNull UUID versionId, @NotBlank @Size(max=100) String bugKey, @NotBlank @Size(max=255) String title, String description, Long departmentId, Long priorityId, Long severityId, @NotNull Long statusId, String tags, String notes, String reviewerComment, LocalDate dueDate) {}
