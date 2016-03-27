package ru.kpfu.itis.tournament.form;

/**
 * Created by etovladislav on 20.03.16.
 */
public class TeamUpdateForm {

    private Long Id;

    private String name;

    private Integer numberDefeats;

    private Integer numberDraw;

    private Integer numberGames;

    private Integer numberPassed;

    private Integer numberPoints;

    private Integer numberScore;

    private Integer numberVictories;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberDefeats() {
        return numberDefeats;
    }

    public void setNumberDefeats(Integer numberDefeats) {
        this.numberDefeats = numberDefeats;
    }

    public Integer getNumberDraw() {
        return numberDraw;
    }

    public void setNumberDraw(Integer numberDraw) {
        this.numberDraw = numberDraw;
    }

    public Integer getNumberGames() {
        return numberGames;
    }

    public void setNumberGames(Integer numberGames) {
        this.numberGames = numberGames;
    }

    public Integer getNumberPassed() {
        return numberPassed;
    }

    public void setNumberPassed(Integer numberPassed) {
        this.numberPassed = numberPassed;
    }

    public Integer getNumberPoints() {
        return numberPoints;
    }

    public void setNumberPoints(Integer numberPoints) {
        this.numberPoints = numberPoints;
    }

    public Integer getNumberScore() {
        return numberScore;
    }

    public void setNumberScore(Integer numberScore) {
        this.numberScore = numberScore;
    }

    public Integer getNumberVictories() {
        return numberVictories;
    }

    public void setNumberVictories(Integer numberVictories) {
        this.numberVictories = numberVictories;
    }
}
