package ru.kpfu.itis.tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.tournament.form.TournamentForm;
import ru.kpfu.itis.tournament.form.TournamentFormToTournament;
import ru.kpfu.itis.tournament.model.Match;
import ru.kpfu.itis.tournament.model.Team;
import ru.kpfu.itis.tournament.model.Tournament;
import ru.kpfu.itis.tournament.model.User;
import ru.kpfu.itis.tournament.repository.TournamentRepository;
import ru.kpfu.itis.tournament.service.TournamentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by etovladislav on 13.03.16.
 */
@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    TournamentRepository tournamentRepository;

    @Override
    public void createTournament(TournamentForm tournamentForm) {
        tournamentRepository.save(TournamentFormToTournament.transform(tournamentForm));
    }

    @Override
    public List<Tournament> getTournaments() {
        return tournamentRepository.findAll();
    }

    @Override
    public List<Tournament> getUserTournaments() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return tournamentRepository.findAllByUserId(user.getId());
    }

    @Override
    public Tournament getTournamentById(Long id) {

        return tournamentRepository.findOneById(id);
    }

    /*
     * Двигает каждую команду в списке на одну позицию по часовой стрелке,
     * кроме 1-ой команды, 2-ая команда уходи в конец
     */
    private Function<List<Team>, List<Team>> changedPosition = s -> {
        Team secondTeam = s.get(1);
        Team temp;
        for (int i = 2; i < s.size(); i++) {
            temp = s.get(i);
            if (i == s.size() - 1) {
                break;
            }
            s.set(i, s.get(i + 1));
            s.set(i - 1, temp);
        }
        s.set(s.size() - 1, secondTeam);
        return s;
    };


    /**
     * Генерирует расписание по круговому формату
     * Оптимизация TODO
     *
     * @param tournamentId
     * @return Tournament
     */
    @Override
    @Transactional
    public Tournament generateSchedule(Long tournamentId) {
        Tournament tournament = tournamentRepository.findOneById(tournamentId);
        List<Match> matches = new ArrayList<>();
        List<Team> teams = tournament.getTeams();
        int numberTeam = teams.size();
        boolean isEven = true;
        if (numberTeam % 2 != 0) {
            isEven = false;
            Team team = new Team();
            team.setName("MISSED_ROUND");
            team.setTournament(tournament);
            teams.add(team);
            numberTeam++;
        }
        int numberTour = isEven ? (numberTeam - 1) : numberTeam;
        int k = numberTeam / 2;
        for (int i = 0; i < numberTour; i++) {
            for (int j = 0; j < k; j++) {
                Match match = new Match();
                match.setTeam1(teams.get(j));
                match.setTeam2(teams.get(j + k));
                match.setTournament(tournament);
                match.setNumberTour(i+1);
                matches.add(match);
            }
            teams = changedPosition.apply(teams);
        }
        tournament.setMatches(matches);
        tournamentRepository.save(tournament);
        return tournament;
    }


}
