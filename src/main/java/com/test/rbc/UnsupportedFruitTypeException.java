package com.test.rbc;

/**
 * Checked exception, that is thrown when item in the basket is not supported
 */
public class UnsupportedFruitTypeException extends Exception {

    public UnsupportedFruitTypeException(String basketItem) {
        super("Basket contains item of type: " + basketItem);
    }

}
