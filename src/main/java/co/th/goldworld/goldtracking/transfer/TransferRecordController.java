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

    @PutMapping("/{code}")
    public TransferRecord updateTransferRecord(@PathVariable("code") final String code,@RequestBody TransferRecord transferRecord){
        transferRecord = transferRecordService.getTransferRecordByCode(code);
        return transferRecordService.updateTransferRecord(transferRecord);
    }

    @GetMapping("/{id}")
    public TransferRecord getTransferRecord(@PathVariable("id") final Long id){
        return transferRecordService.getTransferRecord(id);
    }

    /*
    Called by GSeller system
     */
    @PostMapping("/{code}/receive")
    public void receiveTransferRecord(@PathVariable("code") final String code, @RequestBody Integer employeeId){
        transferRecordService.receiveTransferRecord(code,employeeId);
    }

    /*
    Called by GSeller system
     */
    @PostMapping("/{code}/confirm")
    public void confirmTransferRecord(@PathVariable("code") final String code, @RequestBody Integer employeeId){
        transferRecordService.confirmTransferRecord(code,employeeId);
    }

    @GetMapping("/{id}/print")
    public TransferRecordPrintDTO getTransferRecordPrint(@PathVariable("id") final Long id){
        TransferRecord transferRecord = this.getTransferRecord(id);
        transferRecord.setPrintedDate(ZonedDateTime.now());
        transferRecordService.updateTransferRecord(transferRecord);
        return mapper.map(transferRecord, TransferRecordPrintDTO.class);
    }
}
