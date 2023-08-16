import grocerythings.GroceryList;
import grocerythings.Item;

public class JerkSONParser {
    public static GroceryList dejerkify(String jerksonString){
        GroceryList grocery = new GroceryList();
        String[] itemArr = jerksonString.split("##");
        for(String singularItem : itemArr){
            String[] singularArr = singularItem.split("[^A-Za-z0-9./]");
            grocery.add(createItem(singularArr));
        }
        return grocery;
    }

    public static Item createItem(String[] arr){
        String itemName = capitalize(arr[1]);
        Double itemPrice = null;
        try {
            itemPrice = Double.parseDouble(arr[3]);
        }
        catch (NumberFormatException nfe){}
        String itemType = capitalize(arr[5]);
        String itemExpiration = arr[7];

        return new Item(itemName, itemPrice, itemType, itemExpiration);
    }

    public static String capitalize(String inputString){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (char c : inputString.toCharArray()) {
            if(first){
                first = false;
                sb.append(Character.toUpperCase(c));
            }
            else{
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
