package com.studies.tests.requests.space;

import com.studies.tests.ClickupUrl;
import com.studies.tests.properties.ClickupProperties;
import com.studies.tests.requests.BaseRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public   class CreateSpaceRequest {
    public static Response createSpace(JSONObject space){


   return given()
           .spec(BaseRequest.requestSetupWithLogs())
            .body(space.toString())
            .post(ClickupUrl.getSpacesUrl(ClickupProperties.getTeamId()))
            .then()
            .log().ifError()
            .extract()
            .response();
    }
}
