package actions;

import dto.EmployeeDTO;
import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import utils.RestAssuredUtils;

@AllArgsConstructor
public class CreateEmployee implements Action {

    private EmployeeDTO employeeDTO;

    @Override
    public void execute() {
        RestAssured.given(RestAssuredUtils.REQ_SPEC)
                .body(employeeDTO)
                .post("/employee")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
