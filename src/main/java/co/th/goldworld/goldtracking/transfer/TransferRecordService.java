package co.th.goldworld.goldtracking.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class TransferRecordService {

    @Autowired
    TransferRecordRepository recordRepository;

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

    public void checkoutTransferRecord(Long id){
        TransferRecord transferRecord = this.getTransferRecord(id);
    }

    public void receiveTransferRecord(Long id, Integer employeeId){
        TransferRecord transferRecord = this.getTransferRecord(id);
        transferRecord.setReceiveDate(ZonedDateTime.now());
        transferRecord.setReceiveByUserId(employeeId);
        recordRepository.save(transferRecord);
    }

    public void confirmTransferRecord(Long id, Integer employeeId){
        TransferRecord transferRecord = this.getTransferRecord(id);
        transferRecord.setConfirmDate(ZonedDateTime.now());
        transferRecord.setConfirmByUserId(employeeId);
        recordRepository.save(transferRecord);
    }

}
