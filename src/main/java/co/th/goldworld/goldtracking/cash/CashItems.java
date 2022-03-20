package co.th.goldworld.goldtracking.cash;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class CashItems {
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;
    private String unitKey; // note_1000, note_500, note_100, note_20, coin_10, coin_5
    private String amount; //1000
}
