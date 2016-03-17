package ru.kpfu.itis.tournament.form;

import ru.kpfu.itis.tournament.model.User;

/**
 * Created by etovladislav on 13.03.16.
 */
public class TournamentForm {

    private String tournamentName;

    private String city;

    private Integer countCircular;

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCountCircular() {
        return countCircular;
    }

    public void setCountCircular(Integer countCircular) {
        this.countCircular = countCircular;
    }

    @Override
    public String toString() {
        return "TournamentForm{" +
                "tournamentName='" + tournamentName + '\'' +
                ", city='" + city + '\'' +
                ", countCircular=" + countCircular +
                '}';
    }
}
