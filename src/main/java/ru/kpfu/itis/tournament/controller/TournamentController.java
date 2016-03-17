package ru.kpfu.itis.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.tournament.form.TournamentForm;
import ru.kpfu.itis.tournament.model.Tournament;
import ru.kpfu.itis.tournament.model.User;
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

    @RequestMapping(value = "/api/tournaments/addTeam", method = RequestMethod.GET)
    public void addTeam(@MatrixVariable String name, @MatrixVariable Long tournamentId) {
        System.out.println(name + " " + tournamentId);
    }

}
