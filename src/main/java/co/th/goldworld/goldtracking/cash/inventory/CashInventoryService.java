package co.th.goldworld.goldtracking.cash.inventory;

import co.th.goldworld.goldtracking.cash.item.CashItems;
import co.th.goldworld.goldtracking.cash.summary.CashSummary;
import co.th.goldworld.goldtracking.cash.summary.CashSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class CashInventoryService {

    @Autowired
    CashInventoryRepository cashInventoryRepository;

    @Autowired
    CashSummaryRepository cashSummaryRepository;

    public void addCashItems(Long transferId, List<CashItems> cashItems) {
        CashInventory cashInventory = new CashInventory();
        cashInventory.setCreatedDate(ZonedDateTime.now());
        cashInventory.setTransferId(transferId);
        cashInventory.setCashItems(cashItems);
        cashInventoryRepository.save(cashInventory);
        CashSummary cashSummary = cashSummaryRepository.findFirstOrderById();
        //update summary for report
        cashItems.forEach(i->{
            if(i.getCurrency().equals("THB")) {
                cashSummary.setTHB(cashSummary.getTHB().add(BigDecimal.valueOf(i.getAmount())));
            }
            if(i.getCurrency().equals("USD")) {
                cashSummary.setUSD(cashSummary.getUSD().add(BigDecimal.valueOf(i.getAmount())));
            }
        });
    }

    public void subtractCashItems(Long transferId, List<CashItems> cashItems) {
        CashInventory cashInventory = new CashInventory();
        cashInventory.setCreatedDate(ZonedDateTime.now());
        cashInventory.setTransferId(transferId);
        cashInventory.setCashItems(cashItems);
        cashInventoryRepository.save(cashInventory);
        CashSummary cashSummary = cashSummaryRepository.findFirstOrderById();
        //update summary for report
        cashItems.forEach(i->{
            if(i.getCurrency().equals("THB")) {
                cashSummary.setTHB(cashSummary.getTHB().subtract(BigDecimal.valueOf(i.getAmount())));
            }
            if(i.getCurrency().equals("USD")) {
                cashSummary.setUSD(cashSummary.getUSD().subtract(BigDecimal.valueOf(i.getAmount())));
            }
        });
    }
}
