package ru.kpfu.itis.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.tournament.form.TeamUpdateForm;
import ru.kpfu.itis.tournament.form.TournamentDto;
import ru.kpfu.itis.tournament.form.TournamentForm;
import ru.kpfu.itis.tournament.model.Match;
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
    @ResponseBody
    public List<Match> getSchedule(@PathVariable Long id) {
        return tournamentService.generateSchedule(id).getMatches();
    }

}
