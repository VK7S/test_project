package api.rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.exception.TestException;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestBase {
    /**
     * GET methods
     */
    private Response checkResponseCode(Response response, int expectedCode) {
        if (expectedCode != response.statusCode())
            throw new TestException(String.format("Expected status code %s but was %s \nResponse body: %s",
                    expectedCode, response.statusCode(), response.getBody().print()));
        return response;
    }

    protected Response get(RequestSpecification requestSpec, Map<String, String> params, int expectedStatusCode) {
        return checkResponseCode(getUnChecked(requestSpec, params)
                .then()
                .extract().response(), expectedStatusCode);
    }


    protected Response get(String endPoint, RequestSpecification requestSpec, Map<String, String> params, int expectedStatusCode) {
        return checkResponseCode(given()
                .spec(requestSpec)
                .queryParams(params)
                .contentType(ContentType.URLENC)
                .when()
                .get(endPoint)
                .andReturn(), expectedStatusCode);
    }


    protected Response getUnChecked(RequestSpecification requestSpec, Map<String, String> params) {

        return given()
                .spec(requestSpec)
                .queryParams(params)
                .when()
                .get().then()
                .extract().response();
    }


}
