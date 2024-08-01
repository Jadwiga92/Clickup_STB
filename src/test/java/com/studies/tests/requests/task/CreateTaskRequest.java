package com.studies.tests.requests.task;

import com.studies.tests.ClickupUrl;
import com.studies.tests.dto.request.CreateTaskRequestDto;
import com.studies.tests.dto.response.CreateTaskResponseDto;
import com.studies.tests.requests.BaseRequest;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateTaskRequest {
    public static Response createTaskRequest(JSONObject task, String listId){


        return given()
                .spec(BaseRequest.requestSetupWithLogs())
                .body(task.toString()) //tu trzeba toString
                .post(ClickupUrl.getTasksUrl(listId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
    public static CreateTaskResponseDto createTaskRequestDto(CreateTaskRequestDto task, String listId){


        return given()
                .spec(BaseRequest.requestSetupWithLogs())
                .body(task) // to nie trzeba toString
                .post(ClickupUrl.getTasksUrl(listId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(CreateTaskResponseDto.class);
    }
}
