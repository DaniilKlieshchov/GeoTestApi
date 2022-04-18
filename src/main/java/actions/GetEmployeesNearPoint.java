package actions;

import dto.ZoneDTO;
import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import utils.PojoMapper;
import utils.RestAssuredUtils;

@AllArgsConstructor
public class GetEmployeesNearPoint implements Action{

    private ZoneDTO zoneDTO;

    @Override
    public void execute() {
        var map = PojoMapper.convertToMap(zoneDTO);

        RestAssured.given(RestAssuredUtils.REQ_SPEC)
                .params(map)
                .get("/employees-nearby")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
