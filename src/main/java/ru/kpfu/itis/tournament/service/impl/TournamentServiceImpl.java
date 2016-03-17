package ru.kpfu.itis.tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.tournament.form.TournamentForm;
import ru.kpfu.itis.tournament.form.TournamentFormToTournament;
import ru.kpfu.itis.tournament.model.Tournament;
import ru.kpfu.itis.tournament.model.User;
import ru.kpfu.itis.tournament.repository.TournamentRepository;
import ru.kpfu.itis.tournament.service.TournamentService;

import java.util.List;

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

        return  tournamentRepository.findOneById(id);
    }


}
