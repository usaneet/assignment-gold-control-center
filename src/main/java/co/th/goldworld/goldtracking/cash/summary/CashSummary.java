package co.th.goldworld.goldtracking.cash.summary;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
public class CashSummary {
    private long id;
    private ZonedDateTime createdDate;
    private BigDecimal thb;
    private BigDecimal usd;
    private BigDecimal eur;
    private BigDecimal aud;
}
