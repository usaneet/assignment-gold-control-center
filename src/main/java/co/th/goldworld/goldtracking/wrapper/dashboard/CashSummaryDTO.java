package co.th.goldworld.goldtracking.wrapper.dashboard;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CashSummaryDTO {
    private String currency;
    private BigDecimal amount;
    private BigDecimal exchangeRate;
    private BigDecimal amountTHB;
}
