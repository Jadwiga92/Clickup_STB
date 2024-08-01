package com.studies.tests.requests.space;

import com.studies.tests.ClickupUrl;
import com.studies.tests.properties.ClickupProperties;
import com.studies.tests.requests.BaseRequest;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class DeleteSpaceRequest {
    public static Response deleteSpace(String spaceId){


        return given()
                .spec(BaseRequest.requestSetupWithLogs())
                .delete(ClickupUrl.getSpaceUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
