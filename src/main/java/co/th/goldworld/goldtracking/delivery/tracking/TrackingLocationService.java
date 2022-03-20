package co.th.goldworld.goldtracking.delivery.tracking;

import co.th.goldworld.goldtracking.delivery.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class TrackingLocationService {
    @Autowired
    TrackingLocationRepository locationRepository;

    public void addLocationTracking(Delivery delivery, String latitude, String longitude) {
        TrackingLocation location = new TrackingLocation();
        location.setDateTime(ZonedDateTime.now());
        location.setDeliveryId(delivery);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        locationRepository.save(location);
    }

    public List<TrackingLocation> getLocationTracking(Delivery delivery){
        return locationRepository.findByDeliveryId(delivery.getId());
    }

    public List<TrackingLocation> getAllLocationTracking(Delivery delivery){
        return locationRepository.findByDeliveryId(delivery.getId());
    }
}
