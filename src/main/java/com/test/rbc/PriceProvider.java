package com.test.rbc;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * Class that is designed to proved prices.
 * Currently it is implemented in a static weight, so no price changes are expected to be done on realtime.
 * This might be enhanced in the future.
 * Use {@link #getItemPrice(String)} method to receive price of item.
 */
public final class PriceProvider {

    private static final Map<String, BigDecimal> fruitsPrices;
    static {
        fruitsPrices = new HashMap<>();
        fruitsPrices.put("BANANAS", BigDecimal.valueOf(0.80));
        fruitsPrices.put("ORANGES", BigDecimal.valueOf(1.0));
        fruitsPrices.put("APPLES", BigDecimal.valueOf(1.5));
        fruitsPrices.put("LEMONS", BigDecimal.valueOf(1.25));
        fruitsPrices.put("PEACHES", BigDecimal.valueOf(2.0));
    }

    /**
     * Method to receive price
     *
     * @param item - item name
     * @return BigDecimal price of the item, null if item was not found
     */
    public static BigDecimal getItemPrice(String item) {
        return fruitsPrices.get(item.toUpperCase());
    }
}
