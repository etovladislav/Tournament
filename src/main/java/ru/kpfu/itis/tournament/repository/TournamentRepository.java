package ru.kpfu.itis.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.tournament.model.Tournament;

import java.util.List;

/**
 * Created by etovladislav on 13.03.16.
 */
public interface TournamentRepository extends JpaRepository<Tournament, Long>{

    List<Tournament> findAllByUserId(Long userId);

    Tournament findOneById(Long id);

    @Query(value = "select t.numberTour from Tournament t where t.id = :id")
    Integer getNumberTour(@Param("id") Long id);

}
