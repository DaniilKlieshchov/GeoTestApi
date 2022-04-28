package api.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	@CsvBindByName
	private Integer id;

	@CsvBindByName
	private String name;

	@CsvBindByName
	private int managerId;
}
