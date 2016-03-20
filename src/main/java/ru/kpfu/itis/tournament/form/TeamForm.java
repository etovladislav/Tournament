package ru.kpfu.itis.tournament.form;

/**
 * Created by etovladislav on 20.03.16.
 */
public class TeamForm {

    private String name;

    private Long tournamentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }
}
