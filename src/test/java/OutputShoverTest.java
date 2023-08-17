import grocerythings.GroceryList;
import grocerythings.Item;
import grocerythings.ShoppingBasket;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class OutputShoverTest {
    private final String milk = "Milk";
    private final String bread = "Bread";
    private final String error = "Error";

    private final Double three = 3.23;
    private final Double juan = 1.23;
    private final Double noprice = null;

    private GroceryList createTesterList(){
        Item item1 = new Item(milk, three, "Food", "1/25/2016");
        Item item2 = new Item(bread, juan, "Food", "1/02/2016");
        Item item3 = new Item("", juan, "Food", "11/25/2016");
        Item item4 = new Item(milk, juan, "Food", "3/25/2016");
        Item item5 = new Item(bread, juan, "Food", "3/02/2016");
        Item item6 = new Item(milk, noprice, "Food", "1/25/2016");
        // now populate the list
        GroceryList list = new GroceryList();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        return list;
    }

    @Test
    public void bagItUpTest(){
        //Given
        Integer expectedOne = 1;
        Integer expectedTwo = 2;
        GroceryList grocery = createTesterList();
        //When
        HashMap<String, ShoppingBasket> receipt = OutputShover.bagItUp(grocery);
        ShoppingBasket milkBasket = receipt.get(milk);
        ShoppingBasket breadBasket = receipt.get(bread);
        ShoppingBasket errorBasket = receipt.get(error);
        //Then
        //MILK TESTS FIRST
        Assert.assertNotNull(milkBasket);
        Assert.assertEquals(expectedOne, milkBasket.get(three));
        Assert.assertEquals(expectedOne, milkBasket.get(juan));
        //BREAD TESTS NEXT
        Assert.assertNotNull(breadBasket);
        Assert.assertEquals(expectedTwo, breadBasket.get(juan));
        //FINALLY ERROR TESTS
        Assert.assertNotNull(errorBasket);
        Assert.assertEquals(expectedTwo, errorBasket.get(noprice));
    }

    @Test
    public void printReceiptTest(){
        //Given
        String expected =   "Name:    Milk\t\tseen: 2 times\n" +
                            "=============\t\t=============\n" +
                            "Price:   3.23\t\tseen: 1 time \n" +
                            "-------------\t\t-------------\n" +
                            "Price:   1.23\t\tseen: 1 time \n\n" +
                            "Name:   Bread\t\tseen: 2 times\n" +
                            "=============\t\t=============\n" +
                            "Price:   1.23\t\tseen: 2 times\n" +
                            "-------------\t\t-------------\n\n" +
                            "Errors       \t\tseen: 2 times\n";
        HashMap<String, ShoppingBasket> receipt = OutputShover.bagItUp(createTesterList());
        //When
        String actual = OutputShover.printReceipt(receipt);
        //Then
        Assert.assertEquals(expected, actual);
    }
}