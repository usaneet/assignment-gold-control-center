package co.th.goldworld.goldtracking.cash.summary;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "cash_summary")
public class CashSummary {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private ZonedDateTime createdDate;
    private BigDecimal thb;
    private BigDecimal usd;
    private BigDecimal eur;
    private BigDecimal aud;
}
