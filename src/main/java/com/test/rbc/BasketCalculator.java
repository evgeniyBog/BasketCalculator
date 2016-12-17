package com.test.rbc;

import java.math.BigDecimal;

/**
 * BasketCalculator calculates price for the given basket
 * see {@link #calculate(String[])}
 */

public final class BasketCalculator {

    /**
     * Static method to calculate price of the basket.
     * Throws UnsupportedFruitTypeException in case if item was not found
     *
     * @param basket - String array of items names.
     * @return BigDecimal - price of the items.
     * @throws UnsupportedFruitTypeException - in case if the item is not found in the list.
     */
    public static BigDecimal calculate(String[] basket) throws UnsupportedFruitTypeException {
        BigDecimal basketValue = BigDecimal.ZERO;
        for (String item : iterableArray(basket)) {
            BigDecimal itemPrice = PriceProvider.getItemPrice(item);
            if (itemPrice != null) {
                basketValue = basketValue.add(itemPrice);
            } else {
                throw new UnsupportedFruitTypeException(item);
            }
        }
        return basketValue;
    }

    /**
     * Helper method to safely iterate over nullable array
     * @param items
     * @return
     */
    private static String[] iterableArray(String[] items) {
        return items == null ? new String[0] : items;
    }
}
