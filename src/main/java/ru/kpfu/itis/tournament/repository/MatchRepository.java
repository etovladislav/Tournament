package ru.kpfu.itis.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.tournament.model.Match;

import java.util.List;

/**
 * Created by etovladislav on 27.03.16.
 */
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByTournamentId(Long tournamentId);

}
