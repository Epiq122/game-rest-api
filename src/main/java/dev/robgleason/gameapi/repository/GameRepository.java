package dev.robgleason.gameapi.repository;

import dev.robgleason.gameapi.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource(path = "videogames")
public interface GameRepository extends JpaRepository<Game, Integer> {

}
