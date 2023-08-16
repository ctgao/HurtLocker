import grocerythings.GroceryList;
import grocerythings.Item;
import grocerythings.ShoppingBasket;
import org.junit.Assert;
import org.junit.Test;

public class JerkSONParsingTest {
    @Test
    public void dejerkifyTest() {
        //Given
        String input = "naMe:Milk;price:3.23;type:Food@expiration:1/25/2016##" +
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##" +
                "naMe:;price:;type:Food@expiration:11/25/2016##";
        Item item1 = new Item("Milk", 3.23, "Food", "1/25/2016");
        Item item2 = new Item("Bread", 1.23, "Food", "1/02/2016");
        Item item3 = new Item("", null, "Food", "11/25/2016");
        String expected = item1.toString() + item2.toString() + item3.toString();
        //When
        GroceryList grocery = JerkSONParser.dejerkify(input);
        String actual = grocery.toString();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void capitalizeTest() {
        //Given
        String toggleInput = "tOgGle";
        String expected = "Toggle";
        //When
        String actual = JerkSONParser.capitalize(toggleInput);
        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void capitalizeTest1() {
        //Given
        String expected = "";
        //When
        String actual = JerkSONParser.capitalize(expected);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createItemTest() {
        //Given
        String[] input = {"naMe", "MiLK", "price", "3.23", "type", "Food", "expiration", "1/25/2016"};
        Item expected = new Item("Milk", 3.23, "Food", "1/25/2016");
        //When
        Item actual = JerkSONParser.createItem(input);
        //Then
        Assert.assertEquals(expected, actual);
    }
}