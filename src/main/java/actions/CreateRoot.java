package actions;

import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import utils.RestAssuredUtils;

@AllArgsConstructor
public class CreateRoot implements Action {

    private String name;

    @Override
    public void execute() {
        RestAssured.given(RestAssuredUtils.REQ_SPEC)
                .pathParam("name", name)
                .post("/root")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
