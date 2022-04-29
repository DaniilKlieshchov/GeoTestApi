package api.steps;

import api.HierarchyUtils;
import api.clients.RestClient;
import api.dto.EmployeeManagerDTO;
import api.dto.ManagerEmployeeDTO;
import org.testng.Assert;

public class HierarchySteps {
    private final RestClient restClient;

    public HierarchySteps(RestClient restClient) {
        this.restClient = restClient;
    }

    public void getEmployeeManagersAndValidate(int empId, int targetManagerId){
        EmployeeManagerDTO manager = restClient.get("/employee-managers/{employeeId}", empId, EmployeeManagerDTO.class);
        Assert.assertTrue(HierarchyUtils.isManagerExistsInManagerHierarchy(targetManagerId, manager));
    }

    public void getManagersEmployeeAndValidate(int managerId, int targetEmpId){
        ManagerEmployeeDTO emps = restClient.get("/manager-employees/{managerId}", managerId, ManagerEmployeeDTO.class);
        Assert.assertTrue(HierarchyUtils.isEmpExistsInHierarchy(targetEmpId, emps));
    }
}
