package co.th.goldworld.goldtracking.cash.inventory;

import co.th.goldworld.goldtracking.cash.item.CashItems;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

/*
Cash inventory by each currency and money unit by currency
 */
@Data
@Entity
@Table(name = "cash_inventory")
public class CashInventory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private ZonedDateTime createdDate;
    private ZonedDateTime transferDate;
    private long transferId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CashItems> cashItems;
}
