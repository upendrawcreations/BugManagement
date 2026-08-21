package com.cineflow.bug.dto;
import jakarta.validation.constraints.NotNull; import java.math.BigDecimal;
public record AttachmentMetadata(@NotNull Long attachmentTypeId, BigDecimal duration, String fileUrl) {}
