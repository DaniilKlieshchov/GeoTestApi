package api;

import api.module.ApiModule;
import api.steps.EmployeeSteps;
import api.steps.HierarchySteps;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = {ApiModule.class})
public class EmployeeHierarchyTest {

    @Inject
    EmployeeSteps employeeSteps;

    @Inject
    HierarchySteps hierarchySteps;

    @Test
    void managersHierarchyTest(){
        hierarchySteps.getEmployeeManagersAndValidate(13, 1);
    }
    @Test
    void employeeHierarchyTest(){
        hierarchySteps.getManagersEmployeeAndValidate(1, 9);
    }
}
