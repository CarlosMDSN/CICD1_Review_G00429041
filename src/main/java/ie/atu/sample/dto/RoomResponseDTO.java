package ie.atu.sample.dto;

import lombok.Data;

@Data
public class RoomResponseDTO {

    public Long id;
    private String name;
    private Integer capacity;
}
