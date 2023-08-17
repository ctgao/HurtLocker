package grocerythings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingBasketTest {
    @Test
    public void incrementNewPriceTest() {
        //Given
        int expected = 1;
        double expectedKey = 3.5;
        ShoppingBasket basket = new ShoppingBasket();
        //When
        basket.incrementPrice(expectedKey);
        int actual = basket.get(expectedKey);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void incrementOldPriceTest() {
        //Given
        int expected = 2;
        double expectedKey = 3.5;
        ShoppingBasket basket = new ShoppingBasket();
        basket.incrementPrice(expectedKey);
        //When
        basket.incrementPrice(expectedKey);
        int actual = basket.get(expectedKey);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void countTest(){
        //Given
        int expected = 2;
        ShoppingBasket basket = new ShoppingBasket();
        basket.incrementPrice(3.5);
        //When
        basket.incrementPrice(1.3);
        int actual = basket.count();
        //Then
        Assert.assertEquals(expected, actual);
    }
}