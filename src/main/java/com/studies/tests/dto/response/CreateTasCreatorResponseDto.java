package com.studies.tests.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTasCreatorResponseDto {
    private String username;
    private String email;

    //Ten kod jest niepotrzebny ze względu na lomboka
//    public String getUsername() {
//        return username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String toString() {
//        return "CreateTasCreatorResponseDto{" +
//                "username='" + username + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
}
