package ie.atu.sample.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class BookingResponseDTO {

    private Long id;
    private String organiserName;
    private Integer attendeeCount;
    private Long roomId;
    private String status;
}
