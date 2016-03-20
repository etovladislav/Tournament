package ru.kpfu.itis.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.tournament.model.Team;

/**
 * Created by etovladislav on 20.03.16.
 */
public interface TeamRepository extends JpaRepository<Team, Long>{
    Team save(Team team);
}
