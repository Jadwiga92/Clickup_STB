package com.studies.tests;

import com.studies.tests.requests.space.CreateSpaceRequest;
import com.studies.tests.requests.space.DeleteSpaceRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CreateTestWithParamsTest {
    @ParameterizedTest(name = "Create space with space name: {0}")
    @DisplayName("Create space with valid space name")
    @MethodSource("createSpaceData")
    void createSpaceTest(String spaceName) {
        JSONObject space = new JSONObject();
        space.put("name", spaceName);
//test
        //asdf
        Response response = CreateSpaceRequest.createSpace(space);
        JsonPath json = response.jsonPath();
        String spaceId = json.getString("id");

        Assertions.assertThat(response.statusCode()).isEqualTo(200);
        Assertions.assertThat(json.getString("name")).isEqualTo(spaceName);

        Response deleteResponse = DeleteSpaceRequest.deleteSpace(spaceId);
        Assertions.assertThat(deleteResponse.statusCode()).isEqualTo(HttpStatus.SC_OK);

    }

    private static Stream<Arguments> createSpaceData() {
        return Stream.of(
                Arguments.of("TEST SPACE"),
                Arguments.of("2345324"),
                Arguments.of("2345324")

        );
    }
}
