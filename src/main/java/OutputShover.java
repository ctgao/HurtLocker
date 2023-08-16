import grocerythings.GroceryList;
import grocerythings.Item;
import grocerythings.ShoppingBasket;

import java.util.HashMap;

public class OutputShover {
    public static HashMap bagItUp(GroceryList grocery){
        // setting up the hash map
        HashMap<String, ShoppingBasket> result = new HashMap<>();
        for(Item groceryItem : grocery){
            if(groceryItem.getName().equals("") || groceryItem.getPrice() == null){
                // INVALID NAME OR PRICE!
                addToMap(result, "Error", null);
            }
            else{
                addToMap(result, groceryItem.getName(), groceryItem.getPrice());
            }
        }
        return result;
    }

    public static void addToMap(HashMap<String, ShoppingBasket> map, String bucketName, Double priceBucket){
        ShoppingBasket basket = map.containsKey(bucketName) ? map.get(bucketName) : new ShoppingBasket();
        basket.incrementPrice(priceBucket);
        map.put(bucketName, basket);
    }
}
