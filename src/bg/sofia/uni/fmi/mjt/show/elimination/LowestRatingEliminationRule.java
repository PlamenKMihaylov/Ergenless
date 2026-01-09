package bg.sofia.uni.fmi.mjt.show.elimination;

import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public class LowestRatingEliminationRule implements EliminationRule {
    
    @Override
    public Ergenka[] eliminateErgenkas(Ergenka[] ergenkas) {
        int lowestRating = Integer.MAX_VALUE;
        for (Ergenka ergenka : ergenkas) {
            int rating = ergenka.getRating();
            lowestRating = Math.min(lowestRating, rating);
        }

        int count = 0;
        for (Ergenka ergenka : ergenkas) {
            if (lowestRating != ergenka.getRating()) {
                count++;
            }
        }

        int idx = 0;
        Ergenka[] result = new Ergenka[count];

        for (Ergenka ergenka : ergenkas) {
            if (lowestRating != ergenka.getRating()) {
                result[idx++] = ergenka;
            }
        }

        return result;
    }
}
