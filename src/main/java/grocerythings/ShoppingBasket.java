package grocerythings;

import java.util.HashMap;

public class ShoppingBasket extends HashMap<Double, Integer> {
    public void incrementPrice(Double price){
        Integer valueToPut = this.containsKey(price) ? this.get(price) : 0;
        this.put(price, ++valueToPut);
    }
}
