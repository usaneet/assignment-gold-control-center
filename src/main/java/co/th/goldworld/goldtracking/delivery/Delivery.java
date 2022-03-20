package co.th.goldworld.goldtracking.delivery;

import lombok.Data;

import java.util.List;

@Data
public class Delivery {
    private long id;
    private String mobileId;
    private String driverId; //employee Id
    private String transportationId; //Car Registration
    private String trackingDeviceId;
    private String routeId; //central, north, south, west if any
    private List<TrackingLocation> locationList;
}
