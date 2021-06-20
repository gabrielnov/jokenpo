package dev.gabriel.Jokenpo.repository;

import dev.gabriel.Jokenpo.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long>{
}
