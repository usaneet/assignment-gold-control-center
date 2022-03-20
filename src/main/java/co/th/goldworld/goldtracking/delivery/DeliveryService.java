package co.th.goldworld.goldtracking.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository repository;

    public Delivery createDelivery(Delivery delivery){
        return repository.save(delivery);
    }

    public Delivery updateDelivery(Delivery delivery){
        return repository.save(delivery);
    }

    public Delivery getDeliveryById(Long id){
        return repository.getById(id);
    }

    public Delivery getDeliveryByTrackingDeviceId(String id){
        return repository.findByTrackingDeviceId(id);
    }

    public Delivery getDeliveryByMobileDeviceId(String id){
        return repository.findByMobileDeviceId(id);
    }
}
