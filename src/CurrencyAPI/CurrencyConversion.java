package Currency;

import java.util.stream.Stream;

public enum CurrencyConversion {

    PLN_USD("PLN", "USD"),
    USD_PLN("USD", "PLN"),
    PLN_EUR("PLN", "EUR"),
    EUR_PLN("EUR", "PLN"),
    EUR_USD("EUR", "USD"),
    USD_EUR("USD", "EUR"),
    UNKNOWN("", "");

    public String currencyIn;
    public String currencyOut;

    CurrencyConversion(String currencyIn, String currencyOut) {
        this.currencyIn = currencyIn;
        this.currencyOut = currencyOut;
    }

    public static CurrencyConversion getCurrency(String currencyIn, String currencyOut) {
        return Stream.of(values())
                .filter((CurrencyConversion currencyConversion) -> {
                    return currencyConversion.currencyIn.equals(currencyIn) &&
                            currencyConversion.currencyOut.equals(currencyOut);
                })
                .findAny()
                .orElse(UNKNOWN);
    }
}
