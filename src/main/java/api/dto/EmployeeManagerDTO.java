package api.dto;

import lombok.Data;

@Data
public class EmployeeManagerDTO {
    private int id;
    private String name;
    private EmployeeManagerDTO manager;
}

