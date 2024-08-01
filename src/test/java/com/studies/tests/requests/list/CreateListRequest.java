package com.studies.tests.requests.list;

import com.studies.tests.ClickupUrl;
import com.studies.tests.requests.BaseRequest;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateListRequest {
    public static Response createFolderlessList(JSONObject list, String spaceId){


        return given()
                .spec(BaseRequest.requestSetupWithLogs())
                .body(list.toString())
                .post(ClickupUrl.getListUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
