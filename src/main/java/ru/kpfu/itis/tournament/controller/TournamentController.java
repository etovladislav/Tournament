package ru.kpfu.itis.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.tournament.form.TournamentForm;
import ru.kpfu.itis.tournament.model.Team;
import ru.kpfu.itis.tournament.model.Tournament;
import ru.kpfu.itis.tournament.service.TeamService;
import ru.kpfu.itis.tournament.service.TournamentService;
import ru.kpfu.itis.tournament.form.TeamForm;

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
        return tournamentService.getUserTournaments();
    }

    @RequestMapping(value = "/api/tournaments/getTournamentById/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Tournament getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @RequestMapping(value = "/api/tournaments/addTeam", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Team addTeam(@RequestBody TeamForm team) {
        return teamService.addTeam(team);
    }

}
