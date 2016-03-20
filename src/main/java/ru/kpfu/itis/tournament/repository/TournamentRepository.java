package ru.kpfu.itis.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.tournament.model.Tournament;

import java.util.List;

/**
 * Created by etovladislav on 13.03.16.
 */
public interface TournamentRepository extends JpaRepository<Tournament, Long>{

    List<Tournament> findAllByUserId(Long userId);

    Tournament findOneById(Long id);

}
