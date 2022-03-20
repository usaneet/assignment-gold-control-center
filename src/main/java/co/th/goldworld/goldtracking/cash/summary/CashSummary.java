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
    private BigDecimal THB;
    private BigDecimal USD;
    private BigDecimal EUR;
    private BigDecimal AUD;
}
