package stackoverflow;

public class Vote {
    private final User voter;
    private final VoteType type;

    public Vote(User voter, VoteType type) {
        this.voter = voter;
        this.type = type;
    }

    User getVoter() {
        return voter;
    }

    VoteType getType() {
        return type;
    }
}