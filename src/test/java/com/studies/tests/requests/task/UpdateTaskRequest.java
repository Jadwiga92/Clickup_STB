package com.studies.tests.requests.task;

import com.studies.tests.ClickupUrl;
import com.studies.tests.dto.request.UpdateTaskRequestDto;
import com.studies.tests.requests.BaseRequest;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UpdateTaskRequest {
    public static Response updateTaskDto(UpdateTaskRequestDto taskDto, String taskId){


        return given()
                .spec(BaseRequest.requestSetupWithLogs())
                .body(taskDto) // to nie trzeba toString
                .put(ClickupUrl.getTaskUrl(taskId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }

    public static Response updateTask(JSONObject task, String taskId){


        return given()
                .spec(BaseRequest.requestSetupWithLogs())
                .body(task.toString()) // to nie trzeba toString
                .put(ClickupUrl.getTaskUrl(taskId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
