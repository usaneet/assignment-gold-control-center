package co.th.goldworld.goldtracking.delivery.tracking;

import co.th.goldworld.goldtracking.delivery.tracking.TrackingLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingLocationRepository extends JpaRepository<TrackingLocation, Long> {
}
