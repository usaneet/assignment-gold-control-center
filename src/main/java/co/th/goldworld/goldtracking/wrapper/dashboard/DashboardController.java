package co.th.goldworld.goldtracking.wrapper.dashboard;

import co.th.goldworld.goldtracking.cash.summary.CashSummary;
import co.th.goldworld.goldtracking.cash.summary.CashSummaryService;
import co.th.goldworld.goldtracking.delivery.Delivery;
import co.th.goldworld.goldtracking.delivery.DeliveryService;
import co.th.goldworld.goldtracking.delivery.tracking.TrackingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rgts-service/v1")
public class DashboardController {

    @Autowired
    CashSummaryService cashSummaryService;

    @Autowired
    TrackingLocationService trackingLocationService;

    @Autowired
    DeliveryService deliveryService;

    @GetMapping("/cashsummary")
    public List<CashSummaryDTO> getCashSummary(){
        CashSummary cashSummary = cashSummaryService.getCashSummary();
        CashSummaryDTO cashTHB = new CashSummaryDTO();
        cashTHB.setCurrency("THB");
        cashTHB.setAmount(cashSummary.getTHB());
        cashTHB.setExchangeRate(BigDecimal.ONE); ////getExchangeRate
        cashTHB.setAmountTHB(cashTHB.getAmount().multiply(cashTHB.getExchangeRate()));
        return Arrays.asList(cashTHB);
    }

    @GetMapping("/trackings")
    public List<Delivery> getTracking(){
        return deliveryService.findAllActiveDelivery();
    }
}
