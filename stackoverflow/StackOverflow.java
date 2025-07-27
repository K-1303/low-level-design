package stackoverflow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflow {

    private static final StackOverflow INSTANCE = new StackOverflow();
    private final Map<String, User> users;
    private final Map<String, Question> questions;
    private final Map<String, Answer> answers;
    final Map<String, Tag> tags;

    private StackOverflow() {
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    
}