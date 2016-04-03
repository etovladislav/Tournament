package ru.kpfu.itis.tournament.model;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by etovladislav on 10.03.16.
 */
@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team1_id")
    Team team1;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team2_id")
    Team team2;

    @Column(name = "number_goals_t1")
    Integer numberGoalsT1;

    @Column(name = "number_goals_t2")
    Integer numberGoalsT2;

    @Column(name = "number_tour")
    Integer numberTour;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    @JsonIgnore
    Tournament tournament;

    public Match() {
    }

    public Match(Team team1, Team team2, Integer numberGoalsT1, Integer numberGoalsT2, Integer numberTour, Tournament tournament) {
        this.team1 = team1;
        this.team2 = team2;
        this.numberGoalsT1 = numberGoalsT1;
        this.numberGoalsT2 = numberGoalsT2;
        this.numberTour = numberTour;
        this.tournament = tournament;
    }

    public Integer getNumberTour() {
        return numberTour;
    }

    public void setNumberTour(Integer numberTour) {
        this.numberTour = numberTour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Integer getNumberGoalsT1() {
        return numberGoalsT1;
    }

    public void setNumberGoalsT1(Integer numberGoalsT1) {
        this.numberGoalsT1 = numberGoalsT1;
    }

    public Integer getNumberGoalsT2() {
        return numberGoalsT2;
    }

    public void setNumberGoalsT2(Integer numberGoalsT2) {
        this.numberGoalsT2 = numberGoalsT2;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
