package org.example.factory;

import org.example.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements Split {
    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participants, Map<String, Object> splitDetails) {
        double amountPerPerson = amount / participants.size(); // Divide the amount equally among all participants
        Map<User, Double> splits = new HashMap<>(); // Map to hold the calculated split
        for (User user : participants) {
            splits.put(user, amountPerPerson); // Assign each participant the equal amount
        }
        return splits;
    }
}
