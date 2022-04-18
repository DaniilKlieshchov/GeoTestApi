package actions;

import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import utils.RestAssuredUtils;

@AllArgsConstructor
public class GetEmployeeLocation implements Action{
    private int employeeId;

    @Override
    public void execute() {
        RestAssured.given(RestAssuredUtils.REQ_SPEC)
                .get("/location/{employeeId}", employeeId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
