package api;

import api.clients.RestClient;
import api.dto.EmployeeManagerDTO;
import api.dto.ManagerEmployeeDTO;
import api.steps.EmployeeSteps;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class HierarchyUtils {
    public static boolean isManagerExistsInManagerHierarchy(int managerId, EmployeeManagerDTO employeeManagerDTO){
        EmployeeManagerDTO manager = employeeManagerDTO;
        while (manager!=null){
            if(managerId == manager.getId()){
                return true;
            }
            manager = manager.getManager();
        }
        return false;
    }

    public static boolean isEmpExistsInHierarchy(int empId, ManagerEmployeeDTO managerEmployeeDTO){
        boolean result = managerEmployeeDTO.getId() == empId;
        for (var emp: managerEmployeeDTO.getEmployees()) {
            result = result || isEmpExistsInHierarchy(empId, emp);
        }
        return result;
    }

    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        ManagerEmployeeDTO manager = restClient.get("/manager-employees/{managerId}", 1, ManagerEmployeeDTO.class);
        System.out.println(manager);
        System.out.println(isEmpExistsInHierarchy(1, manager));

    }

}
