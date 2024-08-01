package com.studies.tests;

import com.studies.tests.requests.space.CreateSpaceRequest;
import com.studies.tests.requests.space.DeleteSpaceRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class CreateSpaceTest {


    @Test
    void createSpaceTest() {
        JSONObject space = new JSONObject();
        space.put("name", "nowy space");

        Response response = CreateSpaceRequest.createSpace(space);
        JsonPath json = response.jsonPath();
        String spaceId = json.getString("id");

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(json.getString("name")).isEqualTo("nowy space");

        Response deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(HttpStatus.SC_OK);

    }
}
