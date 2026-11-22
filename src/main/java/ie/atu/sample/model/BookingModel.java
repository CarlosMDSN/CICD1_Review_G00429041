package ie.atu.sample.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String organiserName;

    private Integer attendeeCount;

    private Long roomId;

    private String status = "ACTIVE";
}
