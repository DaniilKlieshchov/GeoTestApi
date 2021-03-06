package api.steps;

import api.clients.RestClient;
import api.dto.EmployeeDTO;
import api.dto.RequestLocationDTO;
import api.dto.ResponseLocationDTO;
import api.dto.UpdateManagerDTO;
import org.testng.Assert;

public class EmployeeSteps {

    private final RestClient restClient;

    public EmployeeSteps(RestClient restClient) {
        this.restClient = restClient;
    }


    public void createEmployeeAndValidate(EmployeeDTO employeeDTO){
        int empId = restClient.post("/employee", employeeDTO, Integer.TYPE);
        var resp = restClient.get("/employee/{id}", empId, EmployeeDTO.class);
        employeeDTO.setId(empId);
        Assert.assertEquals(employeeDTO, resp);
    }

    public void updateEmployeeLocationAndValidate(RequestLocationDTO locationDTO){
        restClient.post("/update-location", locationDTO);
        var respBody = restClient.get("/location/{employeeId}",
                                                    locationDTO.getEmployeeId(),
                                                    ResponseLocationDTO.class);
        Assert.assertEquals(locationDTO.getLat(), respBody.getLat());
        Assert.assertEquals(locationDTO.getLng(), respBody.getLng());
    }

    public void deleteEmployeeAndValidate(int empId){
        restClient.delete("/delete/{employeeId}", empId);
        var resp = restClient.get("/employee/{id}", empId, EmployeeDTO.class);
        Assert.assertNull(resp);
    }

    public void updateManagerAndValidate(UpdateManagerDTO newManger){
        restClient.put("/employee-manager", newManger);
        var resp = restClient.get("/employee/{id}", newManger.getEmployeeId(), EmployeeDTO.class);
        Assert.assertEquals(resp.getManagerId(), newManger.getNewManagerId());
    }


}
