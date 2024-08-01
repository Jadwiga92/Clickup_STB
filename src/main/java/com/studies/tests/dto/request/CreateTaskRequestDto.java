package com.studies.tests.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class CreateTaskRequestDto {

    private String name;
    private String description;
    private String assigneesv;
    private String status;
    private String priority;

//ten kod niepotrzebny, bo wszystko załatwiamy annotacjami z lomboka

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAssigneesv() {
//        return assigneesv;
//    }
//
//    public void setAssigneesv(String assigneesv) {
//        this.assigneesv = assigneesv;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTaskRequestDto{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", assigneesv='" + assigneesv + '\'' +
//                ", status='" + status + '\'' +
//                ", priority='" + priority + '\'' +
//                '}';
//    }
}
