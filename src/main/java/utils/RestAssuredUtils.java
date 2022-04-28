package utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RestAssuredUtils {
    private static final String BASE_URL = "http://localhost:8080";

    public static RequestSpecification REQ_SPEC;

    static {
        REQ_SPEC = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addFilter(new AllureRestAssured())
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .setContentType(ContentType.JSON)
                .build();
    }
}
