package bg.sofia.uni.fmi.mjt.show;

import bg.sofia.uni.fmi.mjt.show.date.DateEvent;
import bg.sofia.uni.fmi.mjt.show.elimination.EliminationRule;
import bg.sofia.uni.fmi.mjt.show.ergenka.Ergenka;

public class ShowAPIImpl implements ShowAPI {
    
    private Ergenka[] ergenkas;

    public ShowAPIImpl(Ergenka[] ergenkas) {
        this.ergenkas = ergenkas;
    }

    @Override
    public Ergenka[] getErgenkas() {
        return this.ergenkas;
    }

    @Override
    public void playRound(DateEvent dateEvent) {
        for (Ergenka e : ergenkas) {
            organizeDate(e, dateEvent);
        }
    }

    @Override
    public void eliminateErgenkas(EliminationRule[] eliminationRules) {
        for(EliminationRule rule : eliminationRules) {
            ergenkas = rule.eliminateErgenkas(ergenkas);
        }
    }

    @Override
    public void organizeDate(Ergenka ergenka, DateEvent dateEvent) {
        ergenka.reactToDate(dateEvent);
    }
}
