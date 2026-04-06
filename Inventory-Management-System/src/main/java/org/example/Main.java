package org.example;

import org.example.entity.InventoryManager;
import org.example.entity.Warehouse;
import org.example.enums.ProductCategory;
import org.example.factory.Product;
import org.example.factory.ProductFactory;
import org.example.strategy.BulkOrderStrategy;
import org.example.strategy.JustInTimeStrategy;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of InventoryManager
        InventoryManager inventoryManager = InventoryManager.getInstance();

        // Create and add warehouses
        Warehouse warehouse1 = new Warehouse(1, "Warehouse 1", "ABC");
        Warehouse warehouse2 = new Warehouse(2, "Warehouse 2", "DEF");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        // Create products using ProductFactory
        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct(
                ProductCategory.ELECTRONICS, "SKU123", "Laptop", 1000.0, 50, 25);
        Product tShirt = productFactory.createProduct(
                ProductCategory.CLOTHING, "SKU456", "T-Shirt", 20.0, 200, 100);
        Product apple = productFactory.createProduct(
                ProductCategory.GROCERY, "SKU789", "Apple", 1.0, 100, 200);

        // Add products to warehouses
        warehouse1.addProduct(laptop, 15);
        warehouse1.addProduct(tShirt, 20);
        warehouse2.addProduct(apple, 50);

        // Set replenishment strategy to Just-In-Time
        inventoryManager.setReplenishmentStrategy(new JustInTimeStrategy());

        // Perform inventory check and replenish if needed
        inventoryManager.performInventoryCheck();

        // Switch replenishment strategy to Bulk Order
        inventoryManager.setReplenishmentStrategy(new BulkOrderStrategy());

        // Replenish a specific product if needed
        inventoryManager.checkAndReplenish("SKU123");
    }
}
