package co.th.goldworld.goldtracking.transfer;

import co.th.goldworld.goldtracking.cash.CashItems;
import co.th.goldworld.goldtracking.delivery.Delivery;
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
    private String code;
    private String issuerSystem;
    private int createByUserId;
    private ZonedDateTime createdDate = ZonedDateTime.now();
    private int modifyByUserId;
    private ZonedDateTime modifiedDate = ZonedDateTime.now();
    private ZonedDateTime printedDate;
    private int sourceBranchId;
    private String sourceBranchAddress;
    private int destinationBranchId;
    private String destinationBranchAddress;
    private String secureBoxId;
    private ZonedDateTime deliveryDate;
    private int deliveryByUserId;
    private ZonedDateTime arrivedDate;
    private int arrivedByUserId;
    private ZonedDateTime receiveDate;
    private int receiveByUserId;
    private ZonedDateTime confirmDate;
    private int confirmByUserId;
    private List<CashItems> cashItems;

    @OneToOne
    private Delivery delivery;
}
