import java.util.*;
class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> orderedVoteMap = new LinkedHashMap<>();
    private NavigableMap<String, Integer> sortedVoteMap = new TreeMap<>();
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVoteMap.put(candidate, orderedVoteMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }
    public void displayVotes() {
        System.out.println("Votes in insertion order --> ");
        for (Map.Entry<String, Integer> entry : orderedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
        System.out.println("\nVotes in sorted order --> ");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Riya");
        system.castVote("Jiya");
        system.castVote("Riya");
        system.castVote("Siya");
        system.castVote("Jiya");
        system.castVote("Riya");
        system.displayVotes();
    }
}
