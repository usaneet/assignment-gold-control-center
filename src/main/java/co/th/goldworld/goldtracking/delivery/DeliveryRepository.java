package co.th.goldworld.goldtracking.delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findByTrackingDeviceId(String id);
    Delivery findByMobileDeviceId(String id);
}
