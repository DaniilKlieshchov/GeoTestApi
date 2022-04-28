package api.steps;

import api.clients.RestClient;
import api.dto.DistanceDTO;
import api.dto.EmployeeGeoDTO;
import api.dto.ZoneDTO;
import lombok.AllArgsConstructor;
import utils.PojoMapper;

import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class GeoSteps {
    private RestClient restClient;


    public void getNearbyEmployeesAndValidate(int empId, DistanceDTO distanceDTO, int nearEmployeeId) {
        var map = PojoMapper.convertToMap(distanceDTO);
        var nearEmps = restClient.get("/employees-nearby/{employeeId}", empId, map, EmployeeGeoDTO[].class);

        assertThat(nearEmps)
                .extracting(EmployeeGeoDTO::getDistance)
                .allMatch(x -> x <= distanceDTO.getDistance());

        assertThat(nearEmps)
                .extracting(EmployeeGeoDTO::getId)
                .contains(nearEmployeeId);
    }

    public void getEmployeesNearPointAndValidate(ZoneDTO zoneDTO, int nearEmployeeId) {
        var map = PojoMapper.convertToMap(zoneDTO);
        var nearEmps = restClient.get("/employees-nearby", map, EmployeeGeoDTO[].class);

        assertThat(nearEmps)
                .extracting(EmployeeGeoDTO::getDistance)
                .allMatch(x -> x <= zoneDTO.getDistance());

        assertThat(nearEmps)
                .extracting(EmployeeGeoDTO::getId)
                .contains(nearEmployeeId);
    }


}
