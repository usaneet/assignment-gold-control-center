package co.th.goldworld.goldtracking.transfer;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;
@Data
public class TransferRecordPrintDTO {
    private String code;
    private String issuerSystem;
    private int sourceBranchId;
    private String sourceBranchAddress;
    private int destinationBranchId;
    private String destinationBranchAddress;
}
