package stackoverflow;
import java.util.UUID;

public class User {
    private final String userId;
    private final String name;
    private final String email;
    private int reputation;

    public User(String name, String email) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.reputation = 0; 
    }

    public void updateReputation(int value) {
        this.reputation += value;

        if (this.reputation < 0) {
            this.reputation = 0; // Ensure reputation does not go below zero
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getReputation() {
        return reputation;
    }

    public String getEmail() {
        return email;
    }
}