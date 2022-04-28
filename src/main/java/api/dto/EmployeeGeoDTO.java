package api.dto;

import lombok.Data;

@Data
public class EmployeeGeoDTO {
    private int id;
    private String name;
    private double distance;
    private double lng;
    private double lat;
    private String updateDateTime;
}
