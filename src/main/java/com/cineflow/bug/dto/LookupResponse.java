package com.cineflow.bug.dto;
public record LookupResponse(Long id, String code, String name, String description, boolean active, Integer sortOrder) {}
