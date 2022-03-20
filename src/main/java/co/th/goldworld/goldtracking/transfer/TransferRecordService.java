package co.th.goldworld.goldtracking.transfer;

import co.th.goldworld.goldtracking.gateway.gseller.GSellerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class TransferRecordService {

    @Autowired
    TransferRecordRepository recordRepository;

    @Autowired
    GSellerInterface gSellerInterface;

    public TransferRecord createTransferRecord(TransferRecord transferRecord){
        transferRecord.setCode(UUID.randomUUID().toString());
        transferRecord.setIssuerSystem("RGTS");
        return recordRepository.save(transferRecord);
    }

    public TransferRecord updateTransferRecord(TransferRecord transferRecord){
        return recordRepository.save(transferRecord);
    }

    public TransferRecord getTransferRecord(Long id){
        return recordRepository.getById(id);
    }

    public TransferRecord getTransferRecordByCode(String code){
        return recordRepository.findByCode(code);
    }

    public void receiveTransferRecord(String qrCode, Integer employeeId){
        TransferRecord transferRecord = this.getTransferRecordByCode(qrCode);
        transferRecord.setReceiveDate(ZonedDateTime.now());
        transferRecord.setReceiveByUserId(employeeId);
        recordRepository.save(transferRecord);
    }

    public void confirmTransferRecord(String qrCode, Integer employeeId){
        TransferRecord transferRecord = this.getTransferRecordByCode(qrCode);
        transferRecord.setConfirmDate(ZonedDateTime.now());
        transferRecord.setConfirmByUserId(employeeId);
        recordRepository.save(transferRecord);
        //TODO:
        //update cash summary
    }

    public void deliveryCheckInTransferRecord(String qrCode, Integer employeeId){
        TransferRecord transferRecord = this.getTransferRecordByCode(qrCode);
        transferRecord.setDeliveryDate(ZonedDateTime.now());
        transferRecord.setDeliveryByUserId(employeeId);
        recordRepository.save(transferRecord);
        //TODO:
        //gSellerInterface update status
    }

    public void deliveryCheckOutTransferRecord(String qrCode, Integer employeeId){
        TransferRecord transferRecord = this.getTransferRecordByCode(qrCode);
        transferRecord.setArrivedDate(ZonedDateTime.now());
        transferRecord.setArrivedByUserId(employeeId);
        recordRepository.save(transferRecord);
        //TODO:
        //gSellerInterface update status
    }

}
