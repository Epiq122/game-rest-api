package dev.robgleason.gameapi.dao;

import dev.robgleason.gameapi.entity.Game;

import java.util.List;

public interface GameDAO {
    List<Game> findAll();

    Game findById(int id);

    Game save(Game game);

    void deleteById(int id);
}
