package grocerythings;

import grocerythings.Item;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ItemTest {
    @Test
    public void testConstructor(){
        //Given
        String expectedName = "Milk";
        double expectedPrice = 1.3;
        String expectedType = "Food";
        Date expectedExpiration = new Date("01/24/2016");
        //When
        Item item = new Item(expectedName, expectedPrice, expectedType, expectedExpiration);
        //Then
        Assert.assertEquals(expectedName, item.getName());
        Assert.assertEquals(expectedPrice, item.getPrice(), 0.0001);
        Assert.assertEquals(expectedType, item.getType());
        Assert.assertEquals(expectedExpiration, item.getExpiration());
    }
    @Test
    public void testConstructorWithStringDate(){
        //Given
        String expectedName = "Milk";
        double expectedPrice = 1.3;
        String expectedType = "Food";
        String expectedExpiration = "1/24/2016";
        //When
        Item item = new Item(expectedName, expectedPrice, expectedType, expectedExpiration);
        //Then
        Assert.assertEquals(expectedName, item.getName());
        Assert.assertEquals(expectedPrice, item.getPrice(), 0.0001);
        Assert.assertEquals(expectedType, item.getType());
        Assert.assertEquals(new Date(expectedExpiration), item.getExpiration());
    }

    @Test
    public void testToString() {
        //Given
        String expectedName = "Milk";
        double expectedPrice = 1.3;
        String expectedType = "Food";
        String expectedExpiration = "01/24/2016";
        Item item = new Item(expectedName, expectedPrice, expectedType, expectedExpiration);
        //When
        String base = "Grocery item: %s cost $%.2f, is a %s item, and expires on %s\n";
        String expected = String.format(base, expectedName, expectedPrice, expectedType, expectedExpiration);
        //Then
        Assert.assertEquals(expected, item.toString());
    }

    @Test
    public void testToStringWithNullPrice() {
        //Given
        String expectedName = "Milk";
        Double expectedPrice = null;
        String expectedType = "Food";
        String expectedExpiration = "01/24/2016";
        Item item = new Item(expectedName, expectedPrice, expectedType, expectedExpiration);
        //When
        String base = "Grocery item: %s cost %s, is a %s item, and expires on %s\n";
        String expected = String.format(base, expectedName, "no price", expectedType, expectedExpiration);
        //Then
        Assert.assertEquals(expected, item.toString());
    }
}