import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stock;

    public Storehouse() {
        this.products = new HashMap<>();
        this.stock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        if (this.products.keySet().contains(product)) {
            return this.products.get(product);
        }

        return -99;
    }

    public int stock(String product) {
        if (this.stock.keySet().contains(product)) {
            return this.stock.get(product);
        }

        return 0;
    }

    public boolean take(String product) {
        if (!this.stock.keySet().contains(product)) {
            return false;
        }

        if (this.stock.get(product) == 0) {
            return false;
        }

        int newStock = this.stock.get(product) - 1;
        this.stock.replace(product, newStock);
        return true;
    }

    public Set<String> products() {
        Set<String> keys = this.products.keySet();
        return keys;
    }
}
