package org.example.observer;

import org.example.factory.Product;

public interface InventoryObserver {
    void update(Product product);
}