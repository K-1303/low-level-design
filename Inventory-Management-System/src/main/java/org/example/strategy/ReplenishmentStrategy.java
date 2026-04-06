package org.example.strategy;

import org.example.factory.Product;

public interface ReplenishmentStrategy {
    // Method to replenish stock for a given product
    void replenish(Product product);
}
