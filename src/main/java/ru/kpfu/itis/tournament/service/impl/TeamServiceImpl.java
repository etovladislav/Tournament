package ru.kpfu.itis.tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.tournament.form.TeamForm;
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
        team.setPoints(0);
        return teamRepository.save(team);
    }
}
