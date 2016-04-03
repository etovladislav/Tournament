package ru.kpfu.itis.tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.tournament.model.Match;
import ru.kpfu.itis.tournament.model.Team;
import ru.kpfu.itis.tournament.repository.MatchRepository;
import ru.kpfu.itis.tournament.repository.TeamRepository;
import ru.kpfu.itis.tournament.service.MatchService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etovladislav on 31.03.16.
 */
@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    @Override
    @Transactional
    public void saveMatch(Match match) {
        Team team1 = teamRepository.findOne(match.getTeam1().getId());
        Team team2 = teamRepository.findOne(match.getTeam2().getId());
        team1.setNumberScore(team1.getNumberScore() + match.getNumberGoalsT1());
        team1.setNumberGames(team1.getNumberGames() + 1);
        team1.setNumberPassed(team1.getNumberPassed() + match.getNumberGoalsT2());

        team2.setNumberScore(team2.getNumberScore() + match.getNumberGoalsT2());
        team2.setNumberGames(team2.getNumberGames() + 1);
        team2.setNumberPassed(team2.getNumberPassed() + match.getNumberGoalsT1());

        if (match.getNumberGoalsT1() > match.getNumberGoalsT2()) {
            team1.setNumberVictories(team1.getNumberVictories() + 1);
            team1.setNumberPoints(team1.getNumberPoints() + 3);
            team2.setNumberDefeats(team2.getNumberDefeats() + 1);
        } else if (match.getNumberGoalsT1() < match.getNumberGoalsT2()) {
            team2.setNumberVictories(team2.getNumberVictories() + 1);
            team2.setNumberPoints(team2.getNumberPoints() + 3);
            team1.setNumberDefeats(team1.getNumberDefeats() + 1);
        } else if (match.getNumberGoalsT1() == match.getNumberGoalsT2()) {
            team1.setNumberDraw(team1.getNumberDraw() + 1);
            team2.setNumberDraw(team2.getNumberDraw() + 1);
        }
        teamRepository.save(team1);
        teamRepository.save(team2);
        match.setTeam1(team1);
        match.setTeam2(team2);
        match.setTournament(team1.getTournament());
        matchRepository.save(match);
    }
}
