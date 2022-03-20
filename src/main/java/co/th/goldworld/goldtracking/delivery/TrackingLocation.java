package co.th.goldworld.goldtracking.delivery;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TrackingLocation {
    private long id;
    private ZonedDateTime dateTime;
    private String latitude;
    private String longitude;
}
