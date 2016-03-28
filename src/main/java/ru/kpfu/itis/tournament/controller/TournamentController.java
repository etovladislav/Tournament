package ru.kpfu.itis.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.tournament.form.*;
import ru.kpfu.itis.tournament.model.Match;
import ru.kpfu.itis.tournament.model.Team;
import ru.kpfu.itis.tournament.model.Tournament;
import ru.kpfu.itis.tournament.service.TeamService;
import ru.kpfu.itis.tournament.service.TournamentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etovladislav on 13.03.16.
 */
@Controller
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/api/tournaments/createTournament", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createTournament(@RequestBody TournamentForm tournament) {
        tournamentService.createTournament(tournament);
    }

    @RequestMapping(value = "/api/tournaments/getTournaments", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Tournament> getTournaments() {
        List<Tournament> tournaments = tournamentService.getUserTournaments();
        return tournaments;
    }

    @RequestMapping(value = "/api/tournaments/getTournamentById/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    TournamentDto getTournamentById(@PathVariable Long id) {
        TournamentDto tournamentDto = new TournamentDto();
        Tournament tournament = tournamentService.getTournamentById(id);
        tournamentDto.setId(tournament.getId());
        tournamentDto.setCity(tournament.getCity());
        tournamentDto.setTeams(tournament.getTeams());
        tournamentDto.setTournamentName(tournament.getTournamentName());
        return tournamentDto;
    }

    @RequestMapping(value = "/api/tournaments/addTeam", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Team addTeam(@RequestBody TeamForm team) {
        return teamService.addTeam(team);
    }

    @RequestMapping(value = "/api/tournaments/editTeam", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Team editTeam(@RequestBody TeamUpdateForm team) {
        return teamService.editTeam(team);
    }

    @RequestMapping(value = "/api/tournaments/generateSchedule/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void generateSchedule(@PathVariable Long id) {
        tournamentService.generateSchedule(id);
    }

    @RequestMapping(value = "/api/tournaments/getSchedule/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Tour> getSchedule(@PathVariable Long id) {
        Integer numberTour = tournamentService.getNumberTour(id);
        List<Match> matches = tournamentService.getSchedule(id);
        List<Tour> tours = new ArrayList<>();
        for(int i = 0; i< numberTour; i++) {
            Tour tour = new Tour();
            tour.setNumberTour(i+1);
            List<Match> matches1 = new ArrayList<>();
            for (Match match : matches) {
                if (match.getNumberTour() == i + 1) {
                    matches1.add(match);
                }
            }
            tour.setMatchList(matches1);
            tours.add(tour);
        }

        return tours;
    }

}
