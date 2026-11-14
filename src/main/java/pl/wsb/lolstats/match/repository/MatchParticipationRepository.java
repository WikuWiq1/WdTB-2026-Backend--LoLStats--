package pl.wsb.lolstats.match.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.lolstats.match.entity.MatchParticipation;

import java.util.List;

public interface MatchParticipationRepository extends JpaRepository<MatchParticipation, Long> {

    /** Wszystkie mecze rozegrane danym bohaterem, np. findByChampion_Name("Ahri"). Zapytanie idzie przez relację champion. */
    List<MatchParticipation> findByChampion_Name(String name);
}
