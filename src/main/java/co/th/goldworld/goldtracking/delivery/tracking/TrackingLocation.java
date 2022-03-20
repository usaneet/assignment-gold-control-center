package co.th.goldworld.goldtracking.delivery.tracking;

import co.th.goldworld.goldtracking.delivery.Delivery;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "tracking_location")
public class TrackingLocation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private ZonedDateTime dateTime;
    private String latitude;
    private String longitude;

    @ManyToOne
    private Delivery deliveryId;
}
