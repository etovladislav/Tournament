package ru.kpfu.itis.tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.tournament.form.TeamForm;
import ru.kpfu.itis.tournament.form.TeamUpdateForm;
import ru.kpfu.itis.tournament.model.Team;
import ru.kpfu.itis.tournament.repository.TeamRepository;
import ru.kpfu.itis.tournament.repository.TournamentRepository;
import ru.kpfu.itis.tournament.service.TeamService;
import ru.kpfu.itis.tournament.service.TournamentService;

/**
 * Created by etovladislav on 20.03.16.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TournamentRepository tournamentRepository;

    @Autowired
    TeamRepository teamRepository;

    @Override
    @Transactional
    public Team addTeam(TeamForm teamForm) {
        Team team = new Team();
        team.setName(teamForm.getName());
        team.setTournament(tournamentRepository.findOneById(teamForm.getTournamentId()));
        team.setNumberDefeats(0);
        team.setNumberDraw(0);
        team.setNumberGames(0);
        team.setNumberPassed(0);
        team.setNumberPoints(0);
        team.setNumberScore(0);
        team.setNumberVictories(0);
        return teamRepository.save(team);
    }

    @Transactional
    public Team editTeam(TeamUpdateForm teamForm) {
        Team team = teamRepository.findOne(teamForm.getId());
        team.setName(teamForm.getName());
        return teamRepository.save(team);
    }
}
