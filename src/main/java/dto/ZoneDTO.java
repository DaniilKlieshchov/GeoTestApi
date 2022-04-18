package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ZoneDTO{
	private Integer distance;
	private Double lng;
	private Double lat;
	private Measure measure;
}
