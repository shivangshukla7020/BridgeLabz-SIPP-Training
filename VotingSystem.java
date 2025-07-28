import java.util.*;

public class VotingSystem {
    Map<String, Integer> votes = new HashMap<>();
    LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
    }

    public TreeMap<String, Integer> sortedResults() {
        return new TreeMap<>(votes);
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();
        vs.castVote("Alice");
        vs.castVote("Bob");
        vs.castVote("Alice");
        System.out.println("Votes: " + vs.votes);
        System.out.println("In order: " + vs.voteOrder);
        System.out.println("Sorted: " + vs.sortedResults());
    }
}
