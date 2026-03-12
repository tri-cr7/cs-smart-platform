package com.cs_smart_platform.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final String field;
    private final String fieldValue;

    public ResourceNotFoundException(String resourceName, String field, Object fieldValue) {
        super(String.format("%s not found with %s: %s", resourceName, field, fieldValue));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldValue = fieldValue.toString();
    }
}
