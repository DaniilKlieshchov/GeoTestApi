package api;

import api.dto.*;
import api.module.ApiModule;
import api.steps.EmployeeSteps;
import api.steps.GeoSteps;
import com.google.inject.Inject;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import utils.CSV;
import utils.CsvDataProvider;


@Guice(modules = {ApiModule.class})
public class EmployeeGeoApiTest {

    @Inject
    private EmployeeSteps employeeSteps;

    @Inject
    private GeoSteps geoSteps;


    @Test
    void nearEmployeeTest(){
        DistanceDTO dist = DistanceDTO.builder()
                .distance(900.0)
                .measure(Measure.KILOMETER)
                .build();
        RequestLocationDTO reqLocation = RequestLocationDTO.builder()
                .employeeId(2)
                .lat(49.85)
                .lng(24.03)
                .build();

        employeeSteps.updateUserLocationAndValidate(reqLocation);
        geoSteps.getNearbyEmployeesAndValidate(1, dist, 2);
    }

    @Test
    void nearPointTest(){
        RequestLocationDTO reqLocation = RequestLocationDTO.builder()
                .employeeId(2)
                .lat(49.85)
                .lng(24.03)
                .build();
        ZoneDTO zoneDTO = ZoneDTO.builder()
                .lat(48.46727)
                .lng(35.06619)
                .distance(900.0)
                .measure(Measure.KILOMETER).build();

        employeeSteps.updateUserLocationAndValidate(reqLocation);
        geoSteps.getEmployeesNearPointAndValidate(zoneDTO, 2);
    }

//    @CSV(path = "src/test/resources/employeesGeo.csv", clazz = EmployeeDTO.class)
//    @Test(dataProvider = "dataProvider", dataProviderClass = CsvDataProvider.class)
//    void createEmployeeTest(EmployeeDTO employeeDTO){
//        employeeSteps.createAndValidate(employeeDTO);
//    }
//
//    @CSV(path = "src/test/resources/employeesGeo.csv", clazz = RequestLocationDTO.class)
//    @Test(dataProvider = "dataProvider", dataProviderClass = CsvDataProvider.class)
//    void updateUserLocationTest(RequestLocationDTO requestLocationDTO){
//        employeeSteps.updateUserLocationAndValidate(requestLocationDTO);
//    }

}
