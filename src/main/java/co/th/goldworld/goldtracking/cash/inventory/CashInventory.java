package co.th.goldworld.goldtracking.cash.inventory;

import co.th.goldworld.goldtracking.cash.CashItems;

import java.time.ZonedDateTime;
import java.util.List;

/*
Cash inventory by each currency and money unit by currency
 */
public class CashInventory {
    private long id;
    private ZonedDateTime createdDate;
    private ZonedDateTime transferDate;
    private long transferId;
    private List<CashItems> cashItems;
}
