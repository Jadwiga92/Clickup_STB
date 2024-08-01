package com.studies.tests.dto.request;

import lombok.Data;

@Data
public class UpdateTaskRequestDto {
    private String name;
    private String description;
    private String assigneesv;
    private String status;
    private String priority;
}
