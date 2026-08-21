package com.cineflow.bug.dto;
import jakarta.validation.constraints.NotNull;
public record FrameRequest(Long frameNumber, String timecode, @NotNull Long frameTypeId, Long startFrame, Long endFrame) {}
