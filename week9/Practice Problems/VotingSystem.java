// File: VotingSystem.java
// Local Inner Class Problem: "Voting System"

import java.util.HashSet;
import java.util.Set;

class VotingSystem {
    private static Set<String> registeredVoters = new HashSet<>();
    
    static {
        // Initialize with some registered voters
        registeredVoters.add("V001");
        registeredVoters.add("V002");
        registeredVoters.add("V003");
        registeredVoters.add("V004");
        registeredVoters.add("V005");
    }
    
    public void processVote(String voterId, String candidate) {
        // Local Inner Class: VoteValidator with .validate() method
        class VoteValidator {
            private String voterId;
            private String candidate;
            
            public VoteValidator(String voterId, String candidate) {
                this.voterId = voterId;
                this.candidate = candidate;
            }
            
            public boolean validate() {
                // Check if voterId is valid and print result
                boolean isValid = registeredVoters.contains(voterId);
                
                if (isValid) {
                    System.out.println("✓ Vote validated for voter " + voterId + " for candidate " + candidate);
                    return true;
                } else {
                    System.out.println("✗ Invalid voter ID: " + voterId + " - Vote rejected");
                    return false;
                }
            }
            
            public String getVoterId() {
                return voterId;
            }
            
            public String getCandidate() {
                return candidate;
            }
        }
        
        // Create and use the local inner class
        VoteValidator validator = new VoteValidator(voterId, candidate);
        boolean isValid = validator.validate();
        
        if (isValid) {
            System.out.println("Vote processed successfully for " + candidate);
        } else {
            System.out.println("Vote processing failed - invalid voter");
        }
        
        System.out.println("---");
    }
    
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        
        System.out.println("=== Voting System ===");
        System.out.println("Registered Voters: " + registeredVoters);
        System.out.println();
        
        // Call processVote with various voterIds
        System.out.println("Processing votes:");
        votingSystem.processVote("V001", "Candidate A");
        votingSystem.processVote("V002", "Candidate B");
        votingSystem.processVote("V999", "Candidate C"); // Invalid voter
        votingSystem.processVote("V003", "Candidate A");
        votingSystem.processVote("V004", "Candidate B");
        votingSystem.processVote("INVALID", "Candidate D"); // Invalid voter
        
        System.out.println("\n=== Vote Summary ===");
        System.out.println("All votes processed using local inner class VoteValidator");
        System.out.println("Local inner class provides encapsulation for vote validation logic");
    }
}
