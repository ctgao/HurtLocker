import grocerythings.GroceryList;
import grocerythings.Item;
import grocerythings.ShoppingBasket;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class OutputShover {
    public static String printReceipt(HashMap<String, ShoppingBasket> receipt){
        StringBuilder sb = new StringBuilder();
        String labelTemplate = "%-6s%7s\t\tseen: %d time%c\n";
        String middle = "=".repeat(13) + "\t\t" + "=".repeat(13) + "\n";
        char plural;
        for(String key : receipt.keySet()) {
            // each key represents one specific food
            if (key.equalsIgnoreCase("Error")) {
                continue;
            }
            // append the name label first
            ShoppingBasket basket = receipt.get(key);
            plural = basket.count() <= 1 ? ' ' : 's';
            sb.append(String.format(labelTemplate, "Name:", key, basket.count(), plural));
            // separate the name from the other stuff
            middle = middle.replaceAll("-", "=");
            sb.append(middle);
            // now do the same for each
            for (Double price : basket.keySet()) {
                String priceAsString = String.format("%.2f", price);
                plural = basket.get(price) <= 1 ? ' ' : 's';
                sb.append(String.format(labelTemplate, "Price:", priceAsString, basket.get(price), plural));
                // make the bar to separate everything and make it look pretty pretty
                middle = middle.replaceAll("=", "-");
                sb.append(middle);
            }
            if (basket.size() != 1){
                // remove the final line of dashes
                sb.delete(sb.length() - middle.length(), sb.length() - 1);
            }
            else{
                sb.append("\n");
            }
        }
        // do this for errors at the end
        plural = receipt.get("Error").count() <= 1 ? ' ' : 's';
        sb.append(String.format(labelTemplate, "Errors", "", receipt.get("Error").count(), plural));
        return sb.toString();
    }

    public static HashMap bagItUp(GroceryList grocery){
        // setting up the hash map
        HashMap<String, ShoppingBasket> result = new LinkedHashMap<>();
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

    private static void addToMap(HashMap<String, ShoppingBasket> map, String bucketName, Double priceBucket){
        ShoppingBasket basket = map.containsKey(bucketName) ? map.get(bucketName) : new ShoppingBasket();
        basket.incrementPrice(priceBucket);
        map.put(bucketName, basket);
    }
}