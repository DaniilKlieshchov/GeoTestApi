package api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseLocationDTO {
    private int id;
    private double lng;
    private double lat;
    @JsonIgnore
    private LocalDateTime updateDateTime;
}
