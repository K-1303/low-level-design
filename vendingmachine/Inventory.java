package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Item> itemMap = new HashMap<>();
    private final Map<String, Integer> itemStock = new HashMap<>();

    public void addItem(String code, Item item, int quantity) {
        itemMap.put(code, item);
        itemStock.put(code, itemStock.getOrDefault(code, 0) + quantity);
    }

    public Item getItem(String code) {
        return itemMap.get(code);
    }

    public boolean isAvailable(String code) {
        return itemStock.getOrDefault(code, 0) > 0;
    }

    public void reduceStock(String code) {
        itemStock.put(code, itemStock.get(code) - 1);
    }
}