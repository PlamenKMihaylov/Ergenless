package bg.sofia.uni.fmi.mjt.show;

import bg.sofia.uni.fmi.mjt.show.ergenka.*;
import bg.sofia.uni.fmi.mjt.show.elimination.*;
import bg.sofia.uni.fmi.mjt.show.date.DateEvent;

public class Main {

    public static void main(String[] args) {

        Ergenka[] ergenkas = {
            new RomanticErgenka("Anna", (short) 25, 5, 3, 10, "Paris"),
            new HumorousErgenka("Maria", (short) 23, 4, 6, 8)
        };

        String[] votes = { "Anna", "Anna", "Maria", "Anna" };

        ShowAPI show = new ShowAPIImpl(ergenkas);

        System.out.println("=== BEFORE DATE ===");
        printErgenkas(show.getErgenkas());

        show.playRound(new DateEvent("Paris",3 , 60));

        System.out.println("=== AFTER DATE ===");
        printErgenkas(show.getErgenkas());

        EliminationRule[] rules = {
            new LowestRatingEliminationRule(),
            new LowAttributeSumEliminationRule(10),
            new PublicVoteEliminationRule(votes)
        };

        show.eliminateErgenkas(rules);

        System.out.println("=== AFTER ELIMINATION ===");
        printErgenkas(show.getErgenkas());
    }

    private static void printErgenkas(Ergenka[] ergenkas) {
        for (Ergenka e : ergenkas) {
            System.out.println(
                e.getName() +
                " | rating=" + e.getRating() +
                " | humor=" + e.getHumorLevel() +
                " | romance=" + e.getRomanceLevel()
            );
        }
    }
}
