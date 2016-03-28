package ru.kpfu.itis.tournament.form;

import ru.kpfu.itis.tournament.model.Match;

import java.util.List;

/**
 * Created by etovladislav on 28.03.16.
 */
public class Tour {

    private Integer numberTour;

    private List<Match> matchList;

    public Integer getNumberTour() {
        return numberTour;
    }

    public void setNumberTour(Integer numberTour) {
        this.numberTour = numberTour;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
}
