package stackoverflow;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class Question implements Votable, Commentable {
    private final String id;
    private final String title;
    private final String content;
    private final User author;
    private final Date creationDate;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Tag> tags;
    private final List<Vote> votes;
    private Answer acceptedAnswer;

    public Question(User author, String title, String content, List<Tag> tags) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
        this.answers = new CopyOnWriteArrayList<>();
        this.comments = new CopyOnWriteArrayList<>();
        this.tags = tags;
        this.votes = new CopyOnWriteArrayList<>();
    }

    public synchronized void addAnswer(Answer answer) {
        answers.add(answer);
    }
    
    public synchronized void acceptAnswer(Answer answer) {
        this.acceptedAnswer = answer;
    }

    @Override
    public void vote(User voter, VoteType type) {
        votes.removeIf(v -> v.getVoter().equals(voter));
        votes.add(new Vote(voter, type));
        author.updateReputation(type == VoteType.UPVOTE ? ReputationType.QUESTION_UPVOTE.getPoints() : ReputationType.QUESTION_DOWNVOTE.getPoints());
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                    .mapToInt(v -> v.getType().getValue())
                    .sum();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }

    public Date getCreationDate() {
        return new Date(creationDate.getTime());
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }
    
}