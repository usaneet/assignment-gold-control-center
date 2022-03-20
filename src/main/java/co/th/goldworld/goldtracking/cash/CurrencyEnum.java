package co.th.goldworld.goldtracking.cash;

public enum CurrencyEnum {
    THB("THB"),
    USD("USD"),
    AUD("AUD"),
    EUR("EUR");

    private String name;
    CurrencyEnum(String currencyName) {
        this.name = currencyName;
    }
}
