package co.th.goldworld.goldtracking.transfer;

import co.th.goldworld.goldtracking.cash.CashItems;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "transfer_record")
public class TransferRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code = UUID.randomUUID().toString();
    private String issuerSystem;
    private int createByUserId;
    private ZonedDateTime createdDate;
    private int modifyByUserId;
    private ZonedDateTime modifiedDate;
    private ZonedDateTime printedDate;
    private int sourceBranchId;
    private String sourceBranchAddress;
    private int destinationBranchId;
    private String destinationBranchAddress;
    private String secureBoxId;
    private String deliveryId;
    private ZonedDateTime deliveryDate;
    private String deliveryByUserId;
    private ZonedDateTime receiveDate;
    private String receiveByUserId;
    private ZonedDateTime confirmDate;
    private String confirmByUserId;
    private List<CashItems> cashItems;
}
