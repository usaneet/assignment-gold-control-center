package co.th.goldworld.goldtracking.delivery;

import co.th.goldworld.goldtracking.delivery.tracking.TrackingLocationService;
import co.th.goldworld.goldtracking.transfer.TransferRecord;
import co.th.goldworld.goldtracking.transfer.TransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/rgts-service/v1")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    TrackingLocationService trackingLocationService;

    @Autowired
    TransferRecordService transferRecordService;

    @PostMapping("/delivery")
    public void createDeliveryRecord(@RequestBody Delivery delivery){
        deliveryService.createDelivery(delivery);
    }

    @PostMapping("/delivery/checkin")
    public void deliveryCheckIn(@RequestBody String mobileId, @RequestBody String qrCode){
        Delivery delivery = deliveryService.getDeliveryByMobileDeviceId(mobileId);
        TransferRecord transferRecord = transferRecordService.getTransferRecordByCode(qrCode);
        if(transferRecord.getDelivery().getId() == delivery.getId()) {
            transferRecordService.deliveryCheckInTransferRecord(qrCode, delivery.getDriverId());
        }
    }

    @PostMapping("/delivery/checkout")
    public void deliveryCheckOut(@RequestBody String mobileId, @RequestBody String qrCode){
        Delivery delivery = deliveryService.getDeliveryByMobileDeviceId(mobileId);
        TransferRecord transferRecord = transferRecordService.getTransferRecordByCode(qrCode);
        if(transferRecord.getDelivery().getId() == delivery.getId()) {
            transferRecordService.deliveryCheckOutTransferRecord(qrCode, delivery.getDriverId());
        }
    }

    @PostMapping("/trackings")
    public void createDeliveryTracking(@RequestBody String deviceId, String latitude, String longitude){
        trackingLocationService.addLocationTracking(deliveryService.getDeliveryByTrackingDeviceId(deviceId), latitude, longitude);
    }
}
