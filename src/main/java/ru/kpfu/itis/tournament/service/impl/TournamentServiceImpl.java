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
import ru.kpfu.itis.tournament.repository.MatchRepository;
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

    @Autowired
    MatchRepository matchRepository;

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

    private Function<List<Team>, List<Team>> changedPosition = s -> {
        int countTeam = s.size();
        int middle = countTeam / 2;

        Team teamInMiddle = s.get(middle - 1);
        Team temp;
        Team[] teams = new Team[countTeam];
        teams[0] = s.get(0);
        teams[countTeam - 1] = s.get(middle - 1);
        teams[1] = s.get(middle);
        for (int i = 2; i < middle; i++) {
            teams[i] = s.get(i-1);
        }
        for (int i = middle; i < countTeam-1; i++) {
            if (i == countTeam - 1) {
                continue;
            }
            teams[i] = s.get(i+1);
        }
        System.err.println(Arrays.toString(teams));
        return new ArrayList<Team>(Arrays.asList(teams));
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
    public void generateSchedule(Long tournamentId) {
        Tournament tournament = tournamentRepository.findOneById(tournamentId);
        List<Match> matches = new ArrayList<>();
        List<Team> teams = tournament.getTeams();
        int numberTeam = teams.size();
        boolean isEven = true;
        if (numberTeam % 2 != 0) {
            isEven = false;
            Team team = new Team();
            team.setName("MISSED_ROUND");
            teams.add(team);
            numberTeam++;
        }
        Integer numberTour = numberTeam - 1;
        int k = numberTeam / 2;
        for (int i = 0; i < numberTour; i++) {
            for (int j = 0; j < k; j++) {
                Match match = new Match();
                match.setTeam1(teams.get(j));
                match.setTeam2(teams.get(j + k));
                match.setTournament(tournament);
                match.setNumberTour(i + 1);
                matches.add(match);
            }
            teams = changedPosition.apply(teams);
        }
        tournament.setNumberTour(numberTour);
        tournament.setMatches(matches);
        tournamentRepository.save(tournament);
    }

    @Override
    public List<Match> getSchedule(Long id) {
        return matchRepository.findByTournamentId(id);
    }

    @Override
    public Integer getNumberTour(Long id) {
        return tournamentRepository.getNumberTour(id);
    }


}
