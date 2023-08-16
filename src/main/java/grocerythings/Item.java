package grocerythings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Item {
    private String name;
    private Double price;
    private String type;
    private Date expiration;
    private final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    //constructor
    public Item(String name, Double price, String type, String expirationDate){
        this(name, price, type, new Date(expirationDate));
    }
    public Item(String name, Double price, String type, Date expiration){
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Date getExpiration() {
        return expiration;
    }

    @Override
    public String toString(){
        String base = "Grocery item: %s cost %s, is a %s item, and expires on %s\n";
        String priceAsString = (price == null) ? "no price" : String.format("$%.2f", price);
        String dateAsString = dateFormat.format(expiration);
        return String.format(base, name, priceAsString, type, dateAsString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(name, item.name) && Objects.equals(type, item.type) && Objects.equals(expiration, item.expiration);
    }
}
