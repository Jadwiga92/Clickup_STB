package com.studies.tests.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskResponseDto {
    private String id;
    private String custom_id;
    private String name;
    @JsonProperty("text_content")
    private String textContent;
    private String description;
    private CreateTasCreatorResponseDto creator;
    private CreateTaskStatusResponseDto status;

//    public String getId() {
//        return id;
//    }
//
//    public String getCustomId() {
//        return custom_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getTextContent() {
//        return textContent;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public CreateTasCreatorResponseDto getCreator() {
//        return creator;
//    }
//
//    public CreateTaskStatusResponseDto getStatus() {
//        return status;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTaskResponseDto{" +
//                "id='" + id + '\'' +
//                ", custom_id='" + custom_id + '\'' +
//                ", name='" + name + '\'' +
//                ", text_content='" + textContent + '\'' +
//                ", description='" + description + '\'' +
//                ", creator=" + creator +
//                ", status=" + status +
//                '}';
//    }
}
