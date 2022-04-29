package api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ManagerEmployeeDTO {
    private Integer id;
    private String name;
    private Integer managerId;
    private List<ManagerEmployeeDTO> employees;
}
