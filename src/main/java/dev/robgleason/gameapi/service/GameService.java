package dev.robgleason.gameapi.service;


import dev.robgleason.gameapi.entity.Game;

import java.util.List;

public interface GameService {
    List<Game> findAll();

}
