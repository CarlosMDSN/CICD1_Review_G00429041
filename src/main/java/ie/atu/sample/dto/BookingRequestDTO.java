package ie.atu.sample.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookingRequestDTO {

    @NotNull(message = "Room ID is required")
    private Long roomId;

    @NotBlank(message = "Organiser name cannot be blank")
    @Size(min = 2, max = 60, message = "Organiser name must be between 2 and 60 characters")
    private String organiserName;

    @NotNull(message = "Attendee count is required")
    @Min(value = 1, message = "Attendee count must be positive")
    private Integer attendeeCount;
}
