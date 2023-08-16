package grocerythings;

import java.util.ArrayList;

public class GroceryList extends ArrayList<Item> {
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Item item : this){
            sb.append(item.toString());
        }
        return sb.toString();
    }
}