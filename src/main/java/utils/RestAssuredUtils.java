package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RestAssuredUtils {
    private static final String BASE_URL = "http://localhost:8080";

    public static RequestSpecification REQ_SPEC;

    static {
        REQ_SPEC = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
