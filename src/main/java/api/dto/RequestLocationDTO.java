package api.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestLocationDTO {

	@CsvBindByName(column = "id")
	private int employeeId;

	@CsvBindByName
	private double lng;

	@CsvBindByName
	private double lat;

}
