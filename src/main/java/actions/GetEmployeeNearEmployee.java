package actions;


import dto.EmployeeZoneDTO;
import dto.ZoneDTO;
import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import utils.PojoMapper;
import utils.RestAssuredUtils;

@AllArgsConstructor
public class GetEmployeeNearEmployee implements Action{
    private int employeeId;
    private ZoneDTO employeeZoneDTO;


    @Override
    public void execute() {
        var map = PojoMapper.convertToMap(employeeZoneDTO);

        RestAssured.given(RestAssuredUtils.REQ_SPEC)
                .params(map)
                .get("/employees-nearby/{employeeId}", employeeId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }
}
