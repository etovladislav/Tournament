package ru.kpfu.itis.tournament.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by etovladislav on 10.03.16.
 */
@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_tournament", nullable = false)
    private String tournamentName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "count_circular", nullable = false)
    private Integer countCircular;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    User user;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Team> teams;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Match> matches;

    public Tournament() {
    }

    public Tournament(String tournamentName, String city, Integer countCircular, User user, List<Team> teams, List<Match> matches) {
        this.tournamentName = tournamentName;
        this.city = city;
        this.countCircular = countCircular;
        this.user = user;
        this.teams = teams;
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
