package org.example.core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.core.properties.Properties;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;

public class ApiClient {

    private static final String TOKEN = System.getProperty(Properties.API_TOKEN);
    private final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    private RequestSpecification requestSpecification;

    public Response sendRequest(Method method, int expectedStatusCode, String url, Object... params) {
        Response response = given()
                .spec(requestSpecification)
                .request(method, url, params).prettyPeek()
                .then().log().status()
                .extract().response();
        if (expectedStatusCode != -1) {
            response = response.then().statusCode(expectedStatusCode).extract().response();
        }
        return response;
    }

    public ApiClient build() {
        requestSpecification = requestSpecBuilder
                .setConfig(newConfig().encoderConfig(encoderConfig().defaultContentCharset(StandardCharsets.UTF_8)))
                .setBaseUri(System.getProperty(Properties.BASE_API_URL))
                .log(LogDetail.ALL)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .addHeader("X-GitHub-Api-Version", "2022-11-28")
                .build();
        return this;
    }

    public ApiClient addQueryParam(String name, String value) {
        requestSpecBuilder.addQueryParam(name, value);
        return this;
    }

    public ApiClient addBody(String body) {
        requestSpecBuilder.setBody(body);
        return this;
    }

    public ApiClient addBody(Object body) {
        requestSpecBuilder.setBody(body);
        return this;
    }

    public ApiClient addJsonContentType() {
        requestSpecBuilder.addHeader("Content-Type", "application/json");
        return this;
    }

}

