package api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistanceDTO {
    private double distance;
    private Measure measure;
}
