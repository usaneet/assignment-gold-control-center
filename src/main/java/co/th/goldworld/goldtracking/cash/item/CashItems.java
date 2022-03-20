package co.th.goldworld.goldtracking.cash.item;

import co.th.goldworld.goldtracking.cash.CurrencyEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cash_items")
public class CashItems {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;
    private String unitKey; // note_1000, note_500, note_100, note_20, coin_10, coin_5
    private int amount; //1000
}
