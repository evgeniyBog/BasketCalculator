package com.test.rbc;

import com.test.rbc.BasketCalculator;
import com.test.rbc.UnsupportedFruitTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.fail;

/**
 * Created by Ievgen_Bogdanov on 12/15/2016.
 */
public class BasketCalculatorTest {

    @Test
    public void testSimpleBasketCalculation() throws UnsupportedFruitTypeException {
        String[] testBasket = {"Oranges", "Bananas", "Peaches"}; //1.0 + 0.8 + 2.0
        BigDecimal price = BasketCalculator.calculate(testBasket);
        Assert.assertNotEquals(price, BigDecimal.ZERO);
        Assert.assertEquals(BigDecimal.valueOf(3.8), price);
    }

    @Test(expected = UnsupportedFruitTypeException.class)
    public void testWrongBasketItem() throws UnsupportedFruitTypeException {
        String[] testBasket = {"Oranges", "Bananas", "Car"};
        BasketCalculator.calculate(testBasket);
        fail("Unsupported item didn't throw proper exception");
    }

    @Test
    public void testEmptyBasket() throws UnsupportedFruitTypeException {
        Assert.assertEquals(BasketCalculator.calculate(null), BigDecimal.ZERO);
    }

    @Test
    public void testOneItemFewTimes() throws UnsupportedFruitTypeException {
        String[] testBasket = {"Bananas", "Bananas"};
        Assert.assertEquals(BasketCalculator.calculate(testBasket), BigDecimal.valueOf(1.6));
    }

    @Test
    public void testOneItem() throws UnsupportedFruitTypeException {
        String[] testBasket = {"Oranges"};
        Assert.assertTrue(BasketCalculator.calculate(testBasket).compareTo(BigDecimal.valueOf(1)) == 0);
    }
}