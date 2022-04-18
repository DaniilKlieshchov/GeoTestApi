package actions;

import dto.LocationDTO;
import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import utils.RestAssuredUtils;

@AllArgsConstructor
public class UpdateEmployeeLocation implements Action{
    private LocationDTO locationDTO;

    @Override
    public void execute() {
        RestAssured.given(RestAssuredUtils.REQ_SPEC)
                .body(locationDTO)
                .post("/update-location")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
