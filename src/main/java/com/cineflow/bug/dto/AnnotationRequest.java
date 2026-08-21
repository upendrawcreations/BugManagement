package com.cineflow.bug.dto;
import jakarta.validation.constraints.*;
public record AnnotationRequest(Long frameNumber, @NotBlank @Size(max=255) String annotationName, @NotNull Long annotationTypeId, String reviewer, String annotationData, String imageUrl) {}
