package grocerythings;

import grocerythings.GroceryList;
import grocerythings.Item;
import org.junit.Assert;
import org.junit.Test;

public class GroceryListTest {
    @Test
    public void testToString() {
        //Given
        Item item1 = new Item("Milk", 3.23, "Food", "1/25/2016");
        Item item2 = new Item("Bread", 1.23, "Food", "1/02/2016");
        String expected = item1.toString() + item2.toString();
        //When
        GroceryList grocery = new GroceryList();
        grocery.add(item1);
        grocery.add(item2);
        String actual = grocery.toString();
        //Then
        Assert.assertEquals(expected, actual);
    }
}