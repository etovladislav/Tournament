package ru.kpfu.itis.tournament.form;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.itis.tournament.model.Tournament;
import ru.kpfu.itis.tournament.model.User;

/**
 * Created by etovladislav on 13.03.16.
 */
public class TournamentFormToTournament {

    public static Tournament transform(TournamentForm tournamentForm) {
        Tournament tournament = new Tournament();
        tournament.setCity(tournamentForm.getCity());
        tournament.setTournamentName(tournamentForm.getTournamentName());
        tournament.setCountCircular(tournamentForm.getCountCircular());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tournament.setUser(user);
        return tournament;
    }
}
