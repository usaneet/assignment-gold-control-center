package co.th.goldworld.goldtracking.delivery;

import co.th.goldworld.goldtracking.delivery.tracking.TrackingLocation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String mobileDeviceId;
    private int driverId; //employee Id
    private String transportationId; //Car Registration
    private String trackingDeviceId;
    private String routeId; //central, north, south, west if any

    @OneToMany(cascade = CascadeType.ALL)
    private List<TrackingLocation> locationList;
}
