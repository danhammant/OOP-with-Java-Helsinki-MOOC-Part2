import java.util.Map;
import java.util.HashMap;

public class ShoppingBasket {
    private Map<String, Purchase> basket;

    public ShoppingBasket() {
        this.basket = new HashMap<>();
    }

    public void add(String product, int price) {
        if (this.basket.keySet().contains(product)) {
            Purchase item = this.basket.get(product);
            item.increaseAmount();
        } else {
            this.basket.put(product, new Purchase(product, 1, price));
        }
    }

    public int price() {
        int price = 0;

        for (Purchase item : this.basket.values()) {
            price += item.price();
        }

        return price;
    }

    public void print() {
        for (Purchase item : this.basket.values()) {
            System.out.println(item);
        }
    }


}
