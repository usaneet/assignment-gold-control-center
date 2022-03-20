package co.th.goldworld.goldtracking.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/rgts-service/v1")
public class TransferRecordController {

    @Autowired
    TransferRecordService transferRecordService;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public TransferRecord createTransferRecord(@RequestBody TransferRecord transferRecord){
        return transferRecordService.createTransferRecord(transferRecord);
    }

    @PutMapping("/{id}")
    public TransferRecord updateTransferRecord(@PathVariable("id") final Long id,@RequestBody TransferRecord transferRecord){
        transferRecord.setId(id);
        return transferRecordService.updateTransferRecord(transferRecord);
    }

    @GetMapping("/{id}")
    public TransferRecord getTransferRecord(@PathVariable("id") final Long id){
        return transferRecordService.getTransferRecord(id);
    }

    @PostMapping("/{id}/checkout")
    public void checkoutTransferRecord(@PathVariable("id") final Long id){
        transferRecordService.checkoutTransferRecord(id);
    }

    @PostMapping("/{id}/receive")
    public void receiveTransferRecord(@PathVariable("id") final Long id, @RequestBody Integer employeeId){
        transferRecordService.receiveTransferRecord(id,employeeId);
    }

    @PostMapping("/{id}/confirm")
    public void confirmTransferRecord(@PathVariable("id") final Long id, @RequestBody Integer employeeId){
        transferRecordService.confirmTransferRecord(id,employeeId);
    }

    @GetMapping("/{id}/print")
    public TransferRecordPrintDTO getTransferRecordPrint(@PathVariable("id") final Long id){
        TransferRecord transferRecord = this.getTransferRecord(id);
        transferRecord.setPrintedDate(ZonedDateTime.now());
        transferRecordService.updateTransferRecord(transferRecord);
        return mapper.map(transferRecord, TransferRecordPrintDTO.class);
    }
}
