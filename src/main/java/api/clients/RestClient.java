package api.clients;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.RestAssuredUtils;

import java.util.Map;

public class RestClient {
    RequestSpecification spec = RestAssuredUtils.REQ_SPEC;


    public <T> T post(String url, Object body, Class<T> clazz) {
        return RestAssured.given(spec)
                .body(body)
                .post(url)
                .then()
                .extract()
                .as(clazz);
    }

    public void post(String url, Object body) {
        RestAssured.given(spec)
                .body(body)
                .post(url);
    }

    public void put(String url, Object body) {
        RestAssured.given(spec)
                .body(body)
                .put(url);
    }

    public void delete(String url, Object pathVariableValue) {
        RestAssured.given(spec)
                .delete(url, pathVariableValue);
    }

    public <T> T get(String url, Object pathVariableValue, Class<T> clazz) {
        return RestAssured.given(spec)
                .get(url, pathVariableValue)
                .then()
                .extract()
                .as(clazz);
    }

    public <T> T get(String url, Map<String, Object> requestParams, Class<T> clazz) {
        return RestAssured.given(spec)
                .params(requestParams)
                .get(url)
                .then()
                .extract()
                .as(clazz);
    }

    public <T> T get(String url, Object pathVariable, Map<String, Object> requestParams, Class<T> clazz) {
        return RestAssured.given(spec)
                .params(requestParams)
                .get(url, pathVariable)
                .then()
                .extract()
                .as(clazz);
    }
}
