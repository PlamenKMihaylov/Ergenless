package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public class PublicVoteEliminationRule implements EliminationRule {

    String[] votes;

    public PublicVoteEliminationRule(String[] votes) {
        this.votes = votes;
    }

    @Override
    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        String mostFreq = null;
        int count = 0;
        for(String vote : votes) {
            if(count == 0) {
                mostFreq = vote;
            }
            if(mostFreq.equalsIgnoreCase(vote)) {
                count++;
            } else {
                count--;
            }
        }

        int votesForCandidate = 0;

        for(String vote : votes) {
            if(vote.equals(mostFreq)) {
                votesForCandidate++;
            }
        }

        if(votesForCandidate <= votes.length / 2) {
            return ergenkas;
        }
        
        int remaining = 0;
        for (Ergenka e : ergenkas) {
            if (!e.getName().equals(mostFreq)) {
                remaining++;
            }
        }

        Ergenka[] result = new Ergenka[remaining];
        int idx = 0;

        for (Ergenka e : ergenkas) {
            if (!e.getName().equals(mostFreq)) {
                result[idx++] = e;
            }
        }

        return result;
    }
}
