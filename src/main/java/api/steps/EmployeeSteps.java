package api.steps;

import api.clients.RestClient;
import api.dto.EmployeeDTO;
import api.dto.RequestLocationDTO;
import api.dto.ResponseLocationDTO;
import org.testng.Assert;

public class EmployeeSteps {

    private final RestClient restClient;

    public EmployeeSteps(RestClient restClient) {
        this.restClient = restClient;
    }

    public void createAndValidate(EmployeeDTO employeeDTO){
        int empId = restClient.post("/employee", employeeDTO, Integer.TYPE);
        var resp = restClient.get("/employee/{id}", empId, EmployeeDTO.class);
        employeeDTO.setId(empId);
        Assert.assertEquals(employeeDTO, resp);
    }

    public void updateUserLocationAndValidate(RequestLocationDTO locationDTO){
        restClient.post("/update-location", locationDTO);
        var respBody = restClient.get("/location/{employeeId}",
                                                    locationDTO.getEmployeeId(),
                                                    ResponseLocationDTO.class);
        Assert.assertEquals(locationDTO.getLat(), respBody.getLat());
        Assert.assertEquals(locationDTO.getLng(), respBody.getLng());
    }
}
