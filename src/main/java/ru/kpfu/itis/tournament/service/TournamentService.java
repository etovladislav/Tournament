package ru.kpfu.itis.tournament.service;

import ru.kpfu.itis.tournament.form.TournamentForm;
import ru.kpfu.itis.tournament.model.Tournament;

import java.util.List;

/**
 * Created by etovladislav on 13.03.16.
 */
public interface TournamentService {

    void createTournament(TournamentForm tournamentForm);

    List<Tournament> getTournaments();

    List<Tournament> getUserTournaments();

    Tournament getTournamentById(Long id);
}
