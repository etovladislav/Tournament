package ru.kpfu.itis.tournament.service;

import ru.kpfu.itis.tournament.form.TeamForm;
import ru.kpfu.itis.tournament.model.Team;

/**
 * Created by etovladislav on 20.03.16.
 */
public interface TeamService {

    Team addTeam(TeamForm teamForm);
}
