package ru.kpfu.itis.tournament.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by etovladislav on 10.03.16.
 */
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    //Очки
    @Column(name = "number_points")
    Integer numberPoints;

    //Количество игр
    @Column(name = "number_games")
    Integer numberGames;

    //количество побед
    @Column(name = "number_victories")
    Integer numberVictories;

    //количество порадений
    @Column(name = "number_defeats")
    Integer numberDefeats;

    //пропущено голов
    @Column(name = "number_passed")
    Integer numberPassed;

    //ничьих
    @Column(name = "number_draw")
    Integer numberDraw;

    //забито голов
    @Column(name = "number_score")
    Integer numberScore;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tournament_id")
    @JsonIgnore
    Tournament tournament;

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberPoints() {
        return numberPoints;
    }

    public void setNumberPoints(Integer numberPoints) {
        this.numberPoints = numberPoints;
    }

    public Integer getNumberGames() {
        return numberGames;
    }

    public void setNumberGames(Integer numberGames) {
        this.numberGames = numberGames;
    }

    public Integer getNumberVictories() {
        return numberVictories;
    }

    public void setNumberVictories(Integer numberVictories) {
        this.numberVictories = numberVictories;
    }

    public Integer getNumberDefeats() {
        return numberDefeats;
    }

    public void setNumberDefeats(Integer numberDefeats) {
        this.numberDefeats = numberDefeats;
    }

    public Integer getNumberPassed() {
        return numberPassed;
    }

    public void setNumberPassed(Integer numberPassed) {
        this.numberPassed = numberPassed;
    }

    public Integer getNumberDraw() {
        return numberDraw;
    }

    public void setNumberDraw(Integer numberDraw) {
        this.numberDraw = numberDraw;
    }

    public Integer getNumberScore() {
        return numberScore;
    }

    public void setNumberScore(Integer numberScore) {
        this.numberScore = numberScore;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
