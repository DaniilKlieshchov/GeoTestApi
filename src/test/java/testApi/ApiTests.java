package testApi;

import actions.GetEmployeeLocation;
import actions.GetEmployeeNearEmployee;
import dto.EmployeeZoneDTO;
import dto.Measure;
import dto.ZoneDTO;
import org.testng.annotations.Test;

@Test
public class ApiTests {

    @Test
    void createNewUser(){
        new GetEmployeeLocation(1).execute();
    }

    @Test
    void getEmployeesNearPoint(){

//        new GetEmployeesNearPoint(
//                ZoneDTO.builder()
//                        .lng(35.06619)
//                        .lat(48.46727)
//                        .distance(900)
//                        .measure(Measure.KILOMETER).build()
//        ).execute();

        ZoneDTO zoneDTO = ZoneDTO.builder()
                .distance(900)
                .measure(Measure.KILOMETER)
                .build();

        new GetEmployeeNearEmployee(2,
                zoneDTO
        ).execute();

    }



}
